



# 숨바꼭질

import heapq
n, m = map(int, input().split())
INF = int(1e9)
graph = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

start = 1
distance = [INF]*(n+1)
distance[start] = 0
q = []
heapq.heappush(q, [0, start])

max_value = 0
while q:
    dist, now = heapq.heappop(q)
    max_value = max(max_value, dist)
    print(dist, now)
    if distance[now] < dist:
        continue
    for next in graph[now]:
        cost = dist+1
        if distance[next] > cost:
            distance[next] = cost
            heapq.heappush(q, [cost, next])


count = []
for i in range(len(distance)):
    if distance[i] == max_value:
        count.append(i)
print(min(count), max_value, len(count))
