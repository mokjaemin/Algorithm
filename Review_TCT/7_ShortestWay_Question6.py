

# 숨바꼭질
# 다익스트라

n, m = map(int, input("입력 : ").split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input("입력 : ").split())
    graph[a].append(b)
    graph[b].append(a)

import heapq
q = []
INF = int(1e9)
distance = [INF]*(n+1)
distance[0] = -1

heapq.heappush(q, (0, 1))
distance[1] = 0

while q:
    dist, now = heapq.heappop(q)
    print("노드", now, "까지의 거리", dist)
    if dist > distance[now]:
        continue
    for check_node in graph[now]:
        if distance[check_node] > dist + 1:
            distance[check_node] = dist + 1
            heapq.heappush(q, (dist+1, check_node))
    print("heapq : ", q)
    print("distance : ", distance)
    print(" ")


result_value = max(distance)
count = 0
shortest = INF
for i in range(len(distance)):
    if distance[i] == result_value:
        shortest = min(i, shortest)
        count += 1

print(" ")
print("최종 결과")
print(shortest, result_value, count)
print(" ")