import numpy as np

def trustworthiness(D_original, D_embedded, *, n_neighbors=5):
    """
    Computes the trustworthiness score to evaluate how well the local structure 
    is preserved after dimensionality reduction.
    
    Parameters:
    - D_original: numpy array of shape (n, n), the pairwise distance matrix in the original high-dimensional space.
    - D_embedded: numpy array of shape (n, n), the pairwise distance matrix in the lower-dimensional space.
    - n_neighbors: int, the number of nearest neighbors to consider.
    
    Returns:
    - float: Trustworthiness score in the range [0, 1], where 1 indicates perfect preservation.
    """
    n = D_original.shape[0]
    
    # For each point i, get the sorted indices in the original space.
    original_sorted_indices = np.argsort(D_original, axis=1)
    # Exclude the self-index (assumed to be the first entry).
    original_neighbors = original_sorted_indices[:, 1:n_neighbors+1]
    
    # Create an array of ranks for the original distances.
    # For each row i, ranks[i, j] gives the rank (starting at 1) of point j in the original ordering.
    original_ranks = np.empty_like(original_sorted_indices)
    for i in range(n):
        original_ranks[i, original_sorted_indices[i]] = np.arange(1, n+1)
    
    # Get the k-nearest neighbors in the embedded space.
    embedded_sorted_indices = np.argsort(D_embedded, axis=1)
    embedded_neighbors = embedded_sorted_indices[:, 1:n_neighbors+1]
    
    # For each point, find the set of points that are in the embedded kNN but not in the original kNN.
    penalty_sum = 0.0
    for i in range(n):
        original_set = set(original_neighbors[i])
        # For each neighbor in the embedded space, if it is not in the original set, add penalty.
        for j in embedded_neighbors[i]:
            if j not in original_set:
                # original_ranks[i, j] is the rank of point j in the original ordering.
                penalty_sum += (original_ranks[i, j] - n_neighbors)
    
    # Normalize according to the formula.
    trust_score = 1 - (2.0 / (n * n_neighbors * (2 * n - 3 * n_neighbors - 1))) * penalty_sum
    return trust_score
