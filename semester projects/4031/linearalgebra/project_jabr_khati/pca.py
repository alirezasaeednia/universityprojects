import matplotlib.pyplot as plt
import numpy as np


class PCA:
    """
    Principal Component Analysis (PCA) for dimensionality reduction.
    """

    def __init__(self, nComponents):
        """
        Initialize PCA with the number of components to retain.

        Parameters:
        - nComponents: int, the number of principal components to keep.
        """
        self.nComponents = nComponents
        self.mean_ = None       
        self.components_ = None   
        self.explainedVarianceRatio_ = None  

    def _centerData(self, data_points):
        self.mean_ = np.mean(data_points, axis=0)
        return data_points - self.mean_

    def _createCov(self, data_points):
        return np.cov(data_points, rowvar=False)

    def _decompose(self, covariance_matrix):
        eigvals, eigvecs = np.linalg.eigh(covariance_matrix)
        sortedIndices = np.argsort(eigvals)[::-1] 
        sortedEigvals = eigvals[sortedIndices]
        sortedEigvecs = eigvecs[:, sortedIndices]
        return sortedEigvals, sortedEigvecs

    def fit(self, data_points):
        """
        Fit the PCA model to the dataset by computing the principal components.

        Parameters:
        - data_points: numpy array, the centered dataset (num_points x num_features).
        """
        data_points_centered = self._centerData(data_points)
        covariance_matrix = self._createCov(data_points_centered)
        eigvals, eigvecs = self._decompose(covariance_matrix)

        self.components_ = eigvecs[:, :self.nComponents]

        total_variance = np.sum(eigvals)
        self.explainedVarianceRatio_ = eigvals[:self.nComponents] / total_variance

    def transform(self, data_points):
        """
        Project the data onto the top principal components.

        Parameters:
        - data_points: numpy array, the data to project (num_points x num_features).

        Returns:
        - transformed_data: numpy array, the data projected onto the top principal components.
        """
        data_points_centered = data_points - self.mean_
        return np.dot(data_points_centered, self.components_)

    def fitTransform(self, data_points):
        """
        Fit the PCA model and transform the data in one step.

        Parameters:
        - data_points: numpy array, the data to fit and transform (num_points x num_features).

        Returns:
        - transformed_data: numpy array, the data projected onto the top principal components.
        """
        self.fit(data_points)
        return self.transform(data_points)

    def inverseTransform(self, transformed_data):
        """
        Reconstruct the original data from the transformed data.

        Parameters:
        - transformed_data: numpy array, the data in the reduced dimensional space.

        Returns:
        - original_data: numpy array, the reconstructed data in the original space.
        """
        return np.dot(transformed_data, self.components_.T) + self.mean_


if __name__ == "__main__":
    import os
    from dataset import load_dataset

    dataset_path = os.path.join(os.path.dirname(__file__), "swissroll.npz")
    data_points, target = load_dataset(dataset_path)

    fig = plt.figure(figsize=(18, 6))

    ax1 = fig.add_subplot(131, projection='3d')
    sc1 = ax1.scatter(data_points[:, 0], data_points[:, 1], data_points[:, 2],
                      c=target, cmap='Spectral', s=20)
    ax1.set_title("Original Swiss Roll (3D)")
    ax1.set_xlabel("X")
    ax1.set_ylabel("Y")
    ax1.set_zlabel("Z")
    plt.colorbar(sc1, ax=ax1, label="Target Parameter")

    pca = PCA(nComponents=2)
    data_points_pca = pca.fitTransform(data_points)

    ax2 = fig.add_subplot(132)
    sc2 = ax2.scatter(data_points_pca[:, 0], data_points_pca[:, 1],
                      c=target, cmap='Spectral', s=20)
    ax2.set_title("PCA Projection (2D)")
    ax2.set_xlabel("PC1")
    ax2.set_ylabel("PC2")
    plt.colorbar(sc2, ax=ax2, label="Target Parameter")

    data_points_reconstructed = pca.inverseTransform(data_points_pca)

    mse_per_feature = np.mean((data_points - data_points_reconstructed) ** 2, axis=0)
    print("Reconstruction MSE per feature:", mse_per_feature)

    ax3 = fig.add_subplot(133, projection='3d')
    sc3 = ax3.scatter(data_points_reconstructed[:, 0], data_points_reconstructed[:, 1], data_points_reconstructed[:, 2],
                      c=target, cmap='Spectral', s=20)
    ax3.set_title("Reconstructed Swiss Roll (3D)")
    ax3.set_xlabel("X")
    ax3.set_ylabel("Y")
    ax3.set_zlabel("Z")
    plt.colorbar(sc3, ax=ax3, label="Target Parameter")

    plt.subplots_adjust(left=0.05, right=0.95, wspace=0.3)
    plt.show()
