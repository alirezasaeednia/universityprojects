import os
import numpy as np
import matplotlib.pyplot as plt

from geo import KNearestNeighbors
from metrics import trustworthiness
from isomap import Isomap
from lle import LLE
from pca import PCA
from dataset import load_dataset
from spectral import LaplacianEigenmaps


def compare_algorithms_swissroll(data_points, target):
    """
    Compare PCA, Isomap, LLE, and Laplacian Eigenmaps on the Swiss Roll dataset.
    """
    transformed_data, trust_scores = apply_dimensionality_reduction(
        data_points, dataset_name="swissroll"
    )

    print("\nTrustworthiness Scores (Swiss Roll Dataset):")
    for algo, score in trust_scores.items():
        print(f"{algo}: {score:.4f}")

    # plot all
    fig, axes = plt.subplots(1, 4, figsize=(24, 5))
    for i, (name, transformed) in enumerate(transformed_data.items()):
        axes[i].scatter(transformed[:, 0], transformed[:, 1], c=target, cmap='Spectral', s=10)
        axes[i].set_title(f"{name} (Trust: {trust_scores[name]:.4f})")

    for ax in axes:
        ax.set_xlabel("Component 1")
        ax.set_ylabel("Component 2")

    plt.tight_layout()
    plt.show()


def compare_algorithms_faces(data_points):
    """
    Compare PCA, Isomap, LLE, and Laplacian Eigenmaps on the ORL Faces dataset.
    """
    transformed_data, trust_scores = apply_dimensionality_reduction(
        data_points, dataset_name="faces"
    )

    print("\nTrustworthiness Scores (Faces Dataset):")
    for algo, score in trust_scores.items():
        print(f"{algo}: {score:.4f}")

    fig, axes = plt.subplots(1, 4, figsize=(24, 5))
    for i, (name, transformed) in enumerate(transformed_data.items()):
        axes[i].scatter(transformed[:, 0], transformed[:, 1], s=10)
        axes[i].set_title(f"{name} (Trust: {trust_scores[name]:.4f})")

    for ax in axes:
        ax.set_xlabel("Component 1")
        ax.set_ylabel("Component 2")

    plt.tight_layout()
    plt.show()


def apply_dimensionality_reduction(data_points, dataset_name="generic", n_neighbors=10, n_components=10):
    """
    Apply PCA, Isomap, LLE, and Laplacian Eigenmaps to the given dataset.

    Parameters:
    - data_points: numpy array, dataset to transform.
    - dataset_name: str, "swissroll" or "faces" (used for setting dynamic n_components).
    - n_neighbors: int or None, number of neighbors for graph-based methods.
    - n_components: int or None, number of components to reduce to.

    Returns:
    - transformed_data: dict containing transformed datasets for each algorithm.
    - trust_scores: dict with trustworthiness scores for each method.
    """
    m = data_points.shape[0]

    algorithms = {
        "PCA": PCA(nComponents=n_components),  # Changed n_components to nComponents
        "Isomap": Isomap(nComponents=n_components, adj_calculator=KNearestNeighbors(n_neighbors)),
        "LLE": LLE(nComponents=n_components, adj_calculator=KNearestNeighbors(n_neighbors)),
        "Laplacian Eigenmaps": LaplacianEigenmaps(n_components=n_components, adj_calculator=KNearestNeighbors(n_neighbors))
    }

    D_original = pairwise_distances(data_points)

    transformed_data = {}
    trust_scores = {}

    for name, model in algorithms.items():
        transformed = model.fitTransform(data_points)
        transformed_data[name] = transformed

        D_transformed = pairwise_distances(transformed)

        trust_scores[name] = trustworthiness(D_original, D_transformed, n_neighbors=n_neighbors)

    return transformed_data, trust_scores

def pairwise_distances(X):
    """
    Compute the pairwise Euclidean distance matrix for data X.
    """
    sq_norms = np.sum(X ** 2, axis=1)
    dists_sq = sq_norms[:, np.newaxis] + sq_norms[np.newaxis, :] - 2 * X @ X.T
    dists = np.sqrt(np.maximum(dists_sq, 0))
    return dists


def apply_pca_faces(data_points, n_components_list):
    """
    Apply PCA to the faces dataset and visualize reconstructed images.
    """

    pca = PCA(nComponents=max(n_components_list))
    pca.fit(data_points)

    plt.figure(figsize=(8, 5))
    plt.plot(np.cumsum(pca.explainedVarianceRatio_), marker='o', linestyle='--')
    plt.xlabel('Number of Components')
    plt.ylabel('Cumulative Explained Variance')
    plt.title('PCA Explained Variance Ratio')
    plt.grid()
    plt.show()

    fig, axes = plt.subplots(len(n_components_list), 2, figsize=(8, len(n_components_list) * 4))
    for i, nComponents in enumerate(n_components_list):
        pca = PCA(nComponents=nComponents)
        data_pca = pca.fitTransform(data_points)
        data_reconstructed = pca.inverseTransform(data_pca)

        axes[i, 0].imshow(data_points[0].reshape(32, 32), cmap='gray')
        axes[i, 0].set_title("Original Image")
        axes[i, 0].axis('off')

        axes[i, 1].imshow(data_reconstructed[0].reshape(32, 32), cmap='gray')
        axes[i, 1].set_title(f"Reconstructed (Components={nComponents})")
        axes[i, 1].axis('off')

    plt.tight_layout()
    plt.show()





if __name__ == "__main__":
    faces_dataset_path = os.path.join(os.path.dirname(__file__), "faces.npz")
    faces_data_points, _ = load_dataset(faces_dataset_path)

    dataset_path = os.path.join(os.path.dirname(__file__), "swissroll.npz")
    swissroll_data_points, target = load_dataset(dataset_path)

    apply_pca_faces(faces_data_points, n_components_list=[10, 40, 75, 111, 150, 199])

    compare_algorithms_swissroll(swissroll_data_points, target)
    compare_algorithms_faces(faces_data_points)
