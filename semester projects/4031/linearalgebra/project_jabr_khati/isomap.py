import heapq
import numpy as np
from geo import KNearestNeighbors, EpsNeighborhood
from pca import PCA


class Isomap:
    """
    Isomap for dimensionality reduction by preserving geodesic distances.
    """

    def __init__(self, nComponents, *, adj_calculator=KNearestNeighbors(10), decomposer=None):
        """
        Initialize Isomap with the number of components and neighbors.

        Parameters:
        - nComponents: int, the number of dimensions to retain in the reduced space.
        - adj_calculator: function, given a dataset, returns the adjacency matrix.
        """
        self.nComponents = nComponents
        self._adj_calculator = adj_calculator
        #self._adj_calculator = EpsNeighborhood(8)  # Uncomment to use EpsNeighborhood instead
        self._decomposer = decomposer or PCA(nComponents=nComponents)

    def _compute_geodesic_distances(self, data_points):
        adjacency_matrix = self._adj_calculator(data_points)  # Get adjacency matrix
        m = adjacency_matrix.shape[0]
        geodesic_distances = np.full((m, m), np.inf)

        adjacency_lists = []
        for i in range(m):
            neighbors = []
            for j in range(m):
                if adjacency_matrix[i, j] < np.inf:
                    neighbors.append((j, adjacency_matrix[i, j]))
            adjacency_lists.append(neighbors)

        for start in range(m):
            pq = [(0, start)]
            geodesic_distances[start, start] = 0
            visited = np.zeros(m, dtype=bool)

            while pq:
                curr_dist, node = heapq.heappop(pq)
                if visited[node]:
                    continue
                visited[node] = True

                for neighbor, weight in adjacency_lists[node]:
                    if not visited[neighbor]:
                        new_dist = curr_dist + weight
                        if new_dist < geodesic_distances[start, neighbor]:
                            geodesic_distances[start, neighbor] = new_dist
                            heapq.heappush(pq, (new_dist, neighbor))

        max_finite_value = np.nanmax(geodesic_distances[geodesic_distances < np.inf])
        geodesic_distances[np.isinf(geodesic_distances)] = max_finite_value

        return geodesic_distances

    def _decompose(self, geodesic_distances): #inja gram matrix misazaim
        """
        Convert the geodesic distance matrix into an inner product matrix and apply PCA.
        """
        n = geodesic_distances.shape[0]
        identity_matrix = np.eye(n)
        ones_matrix = np.ones((n, n))
        centering_matrix = identity_matrix - (1 / n) * ones_matrix

        squared_distances = geodesic_distances ** 2
        gram_matrix = -0.5 * centering_matrix @ squared_distances @ centering_matrix

        return self._decomposer.fitTransform(gram_matrix)

    def fitTransform(self, data_points):
        """
        Fit the Isomap model to the dataset and reduce its dimensionality.
        """
        geodesic_distances = self._compute_geodesic_distances(data_points)

        return self._decompose(geodesic_distances)


if __name__ == "__main__":
    from dataset import load_dataset
    import os
    import matplotlib.pyplot as plt

    dataset_path = os.path.join(os.path.dirname(__file__), "swissroll.npz")
    data_points, target = load_dataset(dataset_path)

    isomap = Isomap(nComponents=2)
    data_points_isomap = isomap.fitTransform(data_points)

    plt.scatter(data_points_isomap[:, 0], data_points_isomap[:, 1], c=target, cmap='Spectral', s=10)
    plt.title("Isomap Projection of Swiss Roll")
    plt.xlabel("Component 1")
    plt.ylabel("Component 2")
    plt.colorbar(label="Target Parameter")
    plt.show()
