import numpy as np

def _compute_distance_matrix(data_points):
    """
    Compute the pairwise Euclidean distance matrix for dataset data_points.
    
    Parameters:
    - data_points: numpy array of shape (num_points, num_features), where num_points is the number of data points.
    
    Returns:
    - distance_matrix: numpy array of shape (num_points, num_points) where distance_matrix[i, j] is the Euclidean
                       distance between point i and point j.
    """
    squared_norms = np.sum(data_points ** 2, axis=1)
    squared_distances = squared_norms[:, np.newaxis] + squared_norms[np.newaxis, :] - 2 * np.dot(data_points, data_points.T)
    distance_matrix = np.sqrt(np.maximum(squared_distances, 0))
    return distance_matrix


class KNearestNeighbors:
    """
    Compute the k-nearest neighbors for each point in the dataset.
    
    The adjacency matrix returned is of shape (num_points, num_points) where num_points is the number of points.
    For each row i, the k smallest distances (excluding the self-distance) are kept,
    while all other entries are set to np.inf.
    
    Attributes:
    - num_neighbors: int, the number of nearest neighbors to retain.
    """
    
    def __init__(self, num_neighbors):
        self.num_neighbors = num_neighbors
    
    def __call__(self, data_points):
        """
        Compute the adjacency matrix based on the k-nearest neighbors.
        
        Parameters:
        - data_points: numpy array of shape (num_points, num_features), where num_points is the number of points.
        
        Returns:
        - adjacency_matrix: numpy array of shape (num_points, num_points) where
                             adjacency_matrix[i, j] = distance between point i and j if j is among
                             the num_neighbors nearest neighbors of i; otherwise, np.inf.
        """
        num_points = data_points.shape[0]
        distance_matrix = _compute_distance_matrix(data_points)
        np.fill_diagonal(distance_matrix, np.inf)
        
        adjacency_matrix = np.full((num_points, num_points), np.inf)
        
        for i in range(num_points):
            # np.argsort returns indices sorted in ascending order.
            nearest_neighbors_indices = np.argsort(distance_matrix[i])[:self.num_neighbors]
            adjacency_matrix[i, nearest_neighbors_indices] = distance_matrix[i, nearest_neighbors_indices]
        
        np.fill_diagonal(adjacency_matrix, 0)
        return adjacency_matrix
    


class EpsNeighborhood:
    """
    Compute the epsilon-neighborhood for each point in the dataset.
    
    For each point, any other point within a radius of epsilon is considered a neighbor.
    The returned adjacency matrix contains the Euclidean distances for pairs within epsilon,
    and np.inf otherwise.
    
    Attributes:
    - epsilon_radius: float, the threshold distance for considering points as neighbors.
    """
    
    def __init__(self, epsilon_radius):
        self.epsilon_radius = epsilon_radius
    
    def __call__(self, data_points):
        """
        Compute the adjacency matrix based on the epsilon-neighborhood.
        
        Parameters:
        - data_points: numpy array of shape (num_points, num_features), where num_points is the number of points.
        
        Returns:
        - adjacency_matrix: numpy array of shape (num_points, num_points) where
                             adjacency_matrix[i, j] = distance between point i and j if the distance is
                             less than epsilon_radius; otherwise, np.inf.
        """
        distance_matrix = _compute_distance_matrix(data_points)
        adjacency_matrix = np.where(distance_matrix < self.epsilon_radius, distance_matrix, np.inf)
        np.fill_diagonal(adjacency_matrix, 0)
        return adjacency_matrix
