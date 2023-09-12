



# 전보

import heapq
INF = int(1e6)
n = 6
graph = [
    [],
    [[4, 3], [2, 1], [5, 2]],
    [[5, 1], [3, 2]],
    [[5, 7]],
    [[5, 5]],
    [],
    []
]
start = 1
distance = [INF]*(n+1)
distance[start] = 0
q = []
heapq.heappush(q, (0, start))
while q:
    # start 노드와 now 노드까지의 거리 : dist
    print(q)
    dist, now = heapq.heappop(q)
    print("start : ", start, " now : ", now, " dist : ", dist)
    if dist > distance[now]:
        continue
    for new in graph[now]:
        cost = new[1] + dist
        print("new : ", new[0])
        print("now와 new까지의 거리 : ", cost)
        print("기존 거리 : ", distance[new[0]])
        if cost < distance[new[0]]:
            distance[new[0]] = cost
            heapq.heappush(q, (cost, new[0]))
    print(distance)
    print(" ")

count = 0
result = []
for i in distance:
    if i < INF:
        count += 1
        result.append(i)
print("도시 수 : ", count)
print("시간 : ", max(result))