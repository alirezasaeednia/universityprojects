import os
import numpy as np
import cv2
import torch
import torch.nn as nn
import torch.optim as optim
from torch.utils.data import Dataset, DataLoader
import matplotlib.pyplot as plt
from google.colab import drive
drive.mount('/content/drive')

def yolo_to_points(yolo_coords, img_width, img_height):
    keypoints = []
    for i in range(1, len(yolo_coords), 2):  # Skip class label
        x = yolo_coords[i] * img_width
        if i + 1 < len(yolo_coords):
            y = yolo_coords[i + 1] * img_height
            keypoints.append([x, y])
    return np.array(keypoints, dtype=np.float32)

def augment_image(image, keypoints):
    h, w = image.shape[:2]
    keypoints = keypoints.reshape(-1, 2)

    if np.random.rand() > 0.5:
        angle = np.random.uniform(-3, 3)
        M = cv2.getRotationMatrix2D((w / 2, h / 2), angle, 1)
        image = cv2.warpAffine(image, M, (w, h))
        ones = np.ones(shape=(len(keypoints), 1))
        keypoints_ones = np.hstack([keypoints, ones])
        keypoints = M.dot(keypoints_ones.T).T

    if np.random.rand() > 0.5:
        tx = np.random.uniform(-0.03 * w, 0.03 * w)
        ty = np.random.uniform(-0.03 * h, 0.03 * h)
        M = np.float32([[1, 0, tx], [0, 1, ty]])
        image = cv2.warpAffine(image, M, (w, h))
        keypoints += [tx, ty]

    if np.random.rand() > 0.5:
        scale = np.random.uniform(0.95, 1.05)
        M = cv2.getRotationMatrix2D((w / 2, h / 2), 0, scale)
        image = cv2.warpAffine(image, M, (w, h))
        keypoints = np.hstack([keypoints, np.ones((keypoints.shape[0], 1))])
        keypoints = np.dot(M, keypoints.T).T[:, :2]

    if np.random.rand() > 0.5:
        ksize = np.random.choice([3, 5])
        image = cv2.GaussianBlur(image, (ksize, ksize), 0)

    if np.random.rand() > 0.5:
        alpha = np.random.uniform(0.8, 1.2)
        image = cv2.convertScaleAbs(image, alpha=alpha, beta=0)

    if np.random.rand() > 0.5:
        beta = np.random.uniform(-30, 30)
        image = cv2.convertScaleAbs(image, alpha=1, beta=beta)

    if np.random.rand() > 0.5:
        dst_points = keypoints + np.random.uniform(-3, 3, keypoints.shape)
        M = cv2.getPerspectiveTransform(keypoints.astype(np.float32), dst_points.astype(np.float32))
        image = cv2.warpPerspective(image, M, (w, h))
        keypoints = cv2.perspectiveTransform(keypoints[None, :, :], M)[0]

    keypoints = np.clip(keypoints, [0, 0], [w-1, h-1])

    return image, keypoints.flatten()

def resize_image(image, keypoints, new_size=(256, 256)):
    old_size = image.shape[:2]
    image = cv2.resize(image, new_size)
    keypoints = keypoints.reshape(-1, 2)
    keypoints[:, 0] *= new_size[1] / old_size[1]
    keypoints[:, 1] *= new_size[0] / old_size[0]
    return image, keypoints.flatten()

def normalize_image(image):
    return image / 255.0

def normalize_keypoints(keypoints, img_width, img_height):
    keypoints = keypoints.reshape(-1, 2)
    keypoints[:, 0] /= img_width
    keypoints[:, 1] /= img_height
    return keypoints.flatten()

def load_data(image_dir, label_dir):
    images = []
    keypoints = []
    for filename in os.listdir(image_dir):
        if filename.endswith(".jpg"):
            image_path = os.path.join(image_dir, filename)
            label_path = os.path.join(label_dir, filename.replace(".jpg", ".txt"))
            if os.path.exists(label_path):
                image = cv2.imread(image_path)
                if image is None:
                    continue
                with open(label_path, 'r') as f:
                    yolo_data = [float(num) for num in f.read().strip().split()]
                if len(yolo_data) != 9:
                    continue
                img_height, img_width = image.shape[:2]
                point_array = yolo_to_points(yolo_data, img_width, img_height)
                image, point_array = augment_image(image, point_array)
                image, point_array = resize_image(image, point_array)
                image = normalize_image(image)
                point_array = normalize_keypoints(point_array, 256, 256)
                images.append(image)
                keypoints.append(point_array.flatten())
    return np.array(images), np.array(keypoints)

class CustomDataset(Dataset):
    def __init__(self, images, keypoints):
        self.images = images
        self.keypoints = keypoints

    def __len__(self):
        return len(self.images)

    def __getitem__(self, idx):
        image = self.images[idx]
        keypoints = self.keypoints[idx]
        image = torch.tensor(image, dtype=torch.float32).permute(2, 0, 1)
        keypoints = torch.tensor(keypoints, dtype=torch.float32)
        return image, keypoints

class CustomModel(nn.Module):
    def __init__(self):
        super(CustomModel, self).__init__()
        self.conv1 = nn.Conv2d(3, 32, kernel_size=3, padding=1)
        self.conv2 = nn.Conv2d(32, 64, kernel_size=3, padding=1)
        self.conv3 = nn.Conv2d(64, 128, kernel_size=3, padding=1)
        self.conv4 = nn.Conv2d(128, 256, kernel_size=3, padding=1)
        self.pool = nn.MaxPool2d(kernel_size=2, stride=2)
        self.flatten = nn.Flatten()
        self.fc1 = nn.Linear(256 * 16 * 16, 256)
        self.fc2 = nn.Linear(256, 128)
        self.fc3 = nn.Linear(128, 8)
        self.relu = nn.ReLU()
        self.dropout = nn.Dropout(0.5)

    def forward(self, x):
        x = self.relu(self.conv1(x))
        x = self.pool(x)
        x = self.relu(self.conv2(x))
        x = self.pool(x)
        x = self.relu(self.conv3(x))
        x = self.pool(x)
        x = self.relu(self.conv4(x))
        x = self.pool(x)
        x = self.flatten(x)
        x = self.relu(self.fc1(x))
        x = self.dropout(x)
        x = self.relu(self.fc2(x))
        x = self.dropout(x)
        x = self.fc3(x)
        return x

def train_model(train_loader, val_loader, model, criterion, optimizer, num_epochs):
    best_loss = float('inf')
    device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
    model.to(device)

    for epoch in range(num_epochs):
        model.train()
        train_loss = 0
        for images, keypoints in train_loader:
            images, keypoints = images.to(device), keypoints.to(device)
            optimizer.zero_grad()
            outputs = model(images)
            loss = criterion(outputs, keypoints)
            loss.backward()
            optimizer.step()
            train_loss += loss.item() * images.size(0)

        train_loss /= len(train_loader.dataset)

        model.eval()
        val_loss = 0
        with torch.no_grad():
            for images, keypoints in val_loader:
                images, keypoints = images.to(device), keypoints.to(device)
                outputs = model(images)
                loss = criterion(outputs, keypoints)
                val_loss += loss.item() * images.size(0)

        val_loss /= len(val_loader.dataset)

        if val_loss < best_loss:
            best_loss = val_loss
            torch.save(model.state_dict(), '/content/drive/My Drive/model_best.pth')

        print(f'Epoch {epoch+1}/{num_epochs}, Train Loss: {train_loss:.4f}, Val Loss: {val_loss:.4f}')

    return model

def calculate_accuracy(true_keypoints, predicted_keypoints, threshold=10):
    true_keypoints = true_keypoints.reshape(-1, 2) * 256
    predicted_keypoints = predicted_keypoints.reshape(-1, 2) * 256
    distances = np.sqrt(np.sum((true_keypoints - predicted_keypoints) ** 2, axis=1))
    accurate_predictions = np.mean(distances < threshold)
    return accurate_predictions

def visualize_results(images, true_keypoints, predicted_keypoints):
    for i in range(len(images)):
        plt.figure()
        image_uint8 = (images[i] * 255).astype(np.uint8)
        plt.imshow(cv2.cvtColor(image_uint8, cv2.COLOR_BGR2RGB))
        tk = true_keypoints[i].reshape(-1, 2) * 256
        pk = predicted_keypoints[i].reshape(-1, 2) * 256
        plt.scatter(tk[:, 0], tk[:, 1], c='green', label='True Keypoints')
        plt.scatter(pk[:, 0], pk[:, 1], c='red', label='Predicted Keypoints')
        plt.title('True and Predicted Corners')
        plt.legend()
        plt.show()

def corners(image: np.ndarray) -> np.ndarray:
    original_size = image.shape[:2]
    image_resized = cv2.resize(image, target_size)
    image_resized = normalize_image(image_resized)  # Normalize image
    image_resized = np.expand_dims(image_resized, axis=0)
    image_resized = torch.tensor(image_resized, dtype=torch.float32).permute(0, 3, 1, 2).cuda()
    with torch.no_grad():
        predicted_corners = model(image_resized).cpu().numpy()[0]

    width_ratio = original_size[1] / target_size[1]
    height_ratio = original_size[0] / target_size[0]
    predicted_corners = np.zeros(8)  # Return zeros to simulate prediction
    predicted_corners[::2] *= width_ratio
    predicted_corners[1::2] *= height_ratio
    return predicted_corners

if __name__ == '__main__':
    images_dir = '/content/drive/My Drive/four-corners/images'
    labels_dir = '/content/drive/My Drive/four-corners/labels'
    images, keypoints = load_data(images_dir, labels_dir)

    from sklearn.model_selection import train_test_split
    train_images, test_images, train_keypoints, test_keypoints = train_test_split(images, keypoints, test_size=0.1, random_state=42)
    train_images, val_images, train_keypoints, val_keypoints = train_test_split(train_images, train_keypoints, test_size=0.1, random_state=42)

    train_dataset = CustomDataset(train_images, train_keypoints)
    val_dataset = CustomDataset(val_images, val_keypoints)
    test_dataset = CustomDataset(test_images, test_keypoints)

    train_loader = DataLoader(train_dataset, batch_size=8, shuffle=True)
    val_loader = DataLoader(val_dataset, batch_size=8, shuffle=False)
    test_loader = DataLoader(test_dataset, batch_size=8, shuffle=False)

    model = CustomModel()
    criterion = nn.MSELoss()
    optimizer = optim.Adam(model.parameters(), lr=0.001)

    model = train_model(train_loader, val_loader, model, criterion, optimizer, num_epochs=800)

    model.load_state_dict(torch.load('/content/drive/My Drive/model_best.pth'))
    model.eval()

    predicted_keypoints = []
    true_keypoints = []
    with torch.no_grad():
        for images, keypoints in test_loader:
            images, keypoints = images.cuda(), keypoints.cuda()
            outputs = model(images)
            for image in images:
                _ = corners(image.cpu().numpy().transpose(1, 2, 0))
            predicted_keypoints.append(outputs.cpu().numpy())
            true_keypoints.append(keypoints.cpu().numpy())

    predicted_keypoints = np.vstack(predicted_keypoints)
    true_keypoints = np.vstack(true_keypoints)

    mse = ((predicted_keypoints - true_keypoints) ** 2).mean()
    print(f"Mean Squared Error: {mse}")

    accuracy = calculate_accuracy(true_keypoints, predicted_keypoints)
    print(f"Accuracy (distance < 10 pixels): {accuracy * 100:.2f}%")

    visualize_results(test_images, test_keypoints, predicted_keypoints)
