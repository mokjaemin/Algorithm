


# 전보


import heapq
n, m, c = 3, 2, 1
graph = [
    [],
    [[2, 4], [3, 2]],
    [],
    []
]

INF = int(1e9)
distance = [INF]*(n+1)
distance[1] = 0
q = []
heapq.heappush(q, [0, 1])




while q:
    dist, now = heapq.heappop(q)
    if dist > distance[now]:
        continue
    for i in graph[now]:
        next_node = i[0]
        next_dist = i[1]
        distance[next_node] = min(next_dist+dist, distance[next_node])
        heapq.heappush(q, [distance[next_node], next_node])

count = 0
max_value = 0
for i in distance:
    if i != INF:
        count += 1
        max_value = max(max_value, i)
print(count-1, max_value)
