import numpy as np
import matplotlib.pyplot as plt
from pca import PCA


def generate_plane(d=2, dim=3, classes=4, num_points=2000, noise=0.1):
    """
    Generate a noisy d-dimensional plane within a dim-dimensional space,
    partitioned into given classes.

    Parameters:
        d (int): Dimension of the plane.
        dim (int): Dimension of the space.
        classes (int): Number of classes.
        num_points (int): Number of points to generate.
        noise (float): Standard deviation of Gaussian noise.

    Returns:
        np.ndarray: Generated points (num_points, dim).
        np.ndarray: Class labels for visualization.
    """
    assert d < dim, "Plane dimension must be less than space dimension"

    plane_points = np.random.uniform(-1, 1, size=(num_points, d))

    data = np.zeros((num_points, dim))
    data[:, :d] = plane_points

    data += np.random.normal(scale=noise, size=(num_points, dim))

    labels = np.floor(((plane_points[:, 0] + 1) / 2) * classes).astype(int) % classes

    return data, labels


def load_dataset(path):
    """
    Load dataset from a .npz file.

    Parameters:
        path (str): Path to the .npz file.

    Returns:
        np.ndarray: Data points.
        np.ndarray: Target labels.
    """
    dataset = np.load(path)
    return dataset['data'], dataset['target']


if __name__ == "__main__":
    data, labels = generate_plane(d=2, dim=3, classes=4, num_points=2000, noise=0.1)

    fig = plt.figure(figsize=(12, 6))
    ax = fig.add_subplot(121, projection='3d')
    sc = ax.scatter(data[:, 0], data[:, 1], data[:, 2], c=labels, cmap='Spectral', s=10)
    ax.set_title("Generated 2D Hyperplane in 3D Space")
    ax.set_xlabel("X")
    ax.set_ylabel("Y")
    ax.set_zlabel("Z")
    plt.colorbar(sc, ax=ax, label="Class Label")

    pca = PCA(nComponents=2)
    data_pca = pca.fitTransform(data)

    ax2 = fig.add_subplot(122)
    sc2 = ax2.scatter(data_pca[:, 0], data_pca[:, 1], c=labels, cmap='Spectral', s=10)
    ax2.set_title("PCA Projection of 2D Hyperplane")
    ax2.set_xlabel("PC1")
    ax2.set_ylabel("PC2")
    plt.colorbar(sc2, ax=ax2, label="Class Label")

    plt.show()
