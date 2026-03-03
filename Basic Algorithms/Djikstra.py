import heapq

# Example graph

# graph = {
#     'A': [('B', 4), ('C', 1)],
#     'B': [('E', 4)],
#     'C': [('B', 2), ('D', 4)],
#     'D': [('E', 4)],
#     'E': []
# }

def djikstra(graph, source):
    # Distance dictionary
    dist = {node: float('inf') for node in graph}
    dist[source] = 0

    # Min heap (distance, node)
    heap = [(0, source)]

    while heap:
        current_dist, current_node = heapq.heappop(heap)

        # Skip if we already found better path
        if current_dist > dist[current_node]:
            continue

        for neighbour, weight in graph[current_node]:
            new_dist = current_dist + weight

            # Relaxation Step
            if new_dist < dist[neighbour]:
                dist[neighbour] = new_dist
                heapq.heappush(heap, (new_dist, neighbour))


    return dist


# Final Distance Array

# dist = {
#     'A': 0,
#     'B': 3,
#     'C': 1,
#     'D': 5, 
#     'E': 7
# }

