import numpy as np
from geo import KNearestNeighbors
from dataset import load_dataset
import matplotlib.pyplot as plt
import os


class LLE:
    """Locally Linear Embedding for nonlinear dimensionality reduction."""

    def __init__(self, nComponents, *, k=10, adj_calculator=None):
        """
        Initialize LLE with the number of components and neighbors.

        Parameters:
        - nComponents: int, the number of dimensions to retain in the reduced space.
        - k: int, number of neighbors to consider for each point.
        - adj_calculator: function, given a dataset, returns the adjacency matrix.
        """
        self.nComponents = nComponents
        self.k = k
        self._adj_calculator = adj_calculator or KNearestNeighbors(k)

    def _compute_weights(self, data_points, distances):
        m, _ = data_points.shape
        k = self.k  # Use the k passed to the LLE constructor
        W = np.zeros((m, m))
        reg = 1e-3  # regularization parameter

        for i in range(m):
            partitioned_indices = np.argpartition(distances[i], k)[:k + 1] #find the smallest k
            sorted_partition = partitioned_indices[
                np.argsort(distances[i][partitioned_indices])
            ]

            if sorted_partition[0] == i: #age khodesh bud mindaze birun
                neighbors = sorted_partition[1:k + 1]
            else:
                neighbors = sorted_partition[:k] #dar gheire insurat hamsaye ro miare

            local_diff = data_points[neighbors] - data_points[i] #fargh ma va hamsaye ha 
            C = local_diff @ local_diff.T #covariance matrix of neighber
            C += np.eye(k) * reg * np.trace(C) #regularize mikonim ta singular nashe

            weights = np.linalg.solve(C, np.ones(k)) 
            print(weights)
            W[i, neighbors] = weights / weights.sum()#motmaen beshim jame w ha mishe 1

        return W

    def _compute_embedding(self, W):
        m = W.shape[0]
        M = (np.eye(m) - W).T @ (np.eye(m) - W)
        _, eigenvectors = np.linalg.eigh(M)

        embedding = eigenvectors[:, 1:self.nComponents + 1]
        embedding *= np.sign(embedding[0, 0]) #kuchiktarin eigen value ro entekhab mikonim

        return embedding

    def fitTransform(self, data_points):
        """
        Fit the LLE model to the dataset and reduce its dimensionality.

        Parameters:
        - data_points: numpy array, the dataset (m x n).
        """
        distances = self._adj_calculator(data_points)
        return self._compute_embedding(self._compute_weights(data_points, distances))


if __name__ == "__main__":
    dataset_path = os.path.join(os.path.dirname(__file__), "swissroll.npz")
    data_points, target = load_dataset(dataset_path)

    lle = LLE(nComponents=2, k=10)  # Pass k directly to LLE
    embedding = lle.fitTransform(data_points)

    plt.figure(figsize=(8, 8))
    plt.scatter(embedding[:, 0], embedding[:, 1], c=target, cmap='Spectral', s=20)
    plt.title("LLE Embedding of Swiss Roll Dataset")
    plt.xlabel("Component 1")
    plt.ylabel("Component 2")
    plt.colorbar(label="Underlying Parameter")
    plt.tight_layout()
    plt.show()
