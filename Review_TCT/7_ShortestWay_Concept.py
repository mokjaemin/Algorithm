

# 다익스트라 알고리즘

# 1. 간단한 다익스트라 알고리즘
def get_smallest_node():
    min_value = INF
    index = 0
    for i in range(1, n+1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i
    return index


def dijkstra(start):
    distance[start] = 0
    visited[start] = 0
    for j in graph[start]:
        distance[j[0]] = j[1]
    for i in range(n-1):
        now = get_smallest_node()
        visited[now] = True
        for j in graph[now]:
            cost = distance[now] + j[1]
            if cost < distance[j[0]]:
                distance[j[0]] = cost




n = 6
INF = int(1e9)
start = 1
graph = [
    [],
    [[2, 2], [3, 5], [4, 1]],
    [[3, 3], [4, 2]],
    [[2, 3], [6, 5]],
    [[3, 3], [5, 1]],
    [[3, 1], [6, 2]]
]
distance = [INF]*(n+1)
visited = [False]*(n+1)

dijkstra(start)
print(distance)


