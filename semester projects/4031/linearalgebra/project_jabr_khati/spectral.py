import numpy as np
from geo import KNearestNeighbors


class LaplacianEigenmaps:

   

    def __init__(self, n_components, *, adj_calculator=None, sigma=1.0):
        """
        Parameters:
        - n_components: int, number of dimensions in the embedded space.
        - k: int, number of nearest neighbors for graph construction.
        - sigma: float, parameter for the heat kernel.
        """
        self.n_components = n_components
        self._adj_calculator = adj_calculator if adj_calculator else KNearestNeighbors(10)
        self.sigma = sigma

    def fitTransform(self, data_points):
        """
        Compute the low-dimensional embedding for dataset X.

        Parameters:
        - data_points: numpy array of shape (m, n), where m is the number of samples.

        Returns:
        - embedding: numpy array of shape (m, n_components)
        """
        m = data_points.shape[0]

        adjacency_matrix = self._adj_calculator(data_points) #matrix hamsayegi ba knn

        # COMPUTE WEIGHT MATRIX
        W = np.zeros((m, m))
        finite_mask = np.isfinite(adjacency_matrix)
        W[finite_mask] = np.exp(-np.square(adjacency_matrix[finite_mask]) / (self.sigma ** 2))
        W = np.maximum(W, W.T)  # Ensure symmetry

        # DEGREE MATRIX
        degree_vector = np.sum(W, axis=1)
        print(degree_vector)
        degree_matrix = np.diag(degree_vector)
        print(degree_matrix)

        #epsilon ezafe mikonim ta taghsim bar 0 nade
        eps = 1e-10
        D_inv_sqrt = np.diag(1.0 / np.sqrt(degree_vector + eps))
        print(D_inv_sqrt)
        #laplacian marix
        I = np.eye(m)
        L = degree_matrix - W
        eigvals, eigvecs = np.linalg.eigh(L)

        #eigen decomp

        embedding = eigvecs[:, 1:self.n_components + 1]
        embedding *= np.sign(embedding[0, 0])

        return embedding


if __name__ == "__main__":
    import matplotlib.pyplot as plt
    from dataset import load_dataset
    import os

    # Load the Swiss Roll dataset
    dataset_path = os.path.join(os.path.dirname(__file__), "swissroll.npz")
    data_points, color = load_dataset(dataset_path)

    # Apply Laplacian Eigenmaps with optimized parameters
    le = LaplacianEigenmaps(n_components=2, adj_calculator=KNearestNeighbors(10), sigma=1.0)
    embedding = le.fitTransform(data_points)

    # Plot the resulting 2D embedding
    plt.figure(figsize=(8, 8))
    scatter = plt.scatter(embedding[:, 0], embedding[:, 1], c=color, cmap='Spectral', s=10)
    plt.colorbar(scatter, label="Parameter")
    plt.title("Laplacian Eigenmaps Embedding (2D) of Swiss Roll")
    plt.xlabel("Component 1")
    plt.ylabel("Component 2")
    plt.axis('equal')
    plt.show()
