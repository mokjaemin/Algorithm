

# 다익스트라 알고리즘

# 1. 간단한 다익스트라 알고리즘
# def get_smallest_node():
#     min_value = INF
#     index = 0
#     for i in range(1, n+1):
#         if distance[i] < min_value and not visited[i]:
#             min_value = distance[i]
#             index = i
#     return index


# def dijkstra(start):
#     distance[start] = 0
#     visited[start] = 0
#     for j in graph[start]:
#         distance[j[0]] = j[1]
#     for i in range(n-1):
#         now = get_smallest_node()
#         visited[now] = True
#         for j in graph[now]:
#             cost = distance[now] + j[1]
#             if cost < distance[j[0]]:
#                 distance[j[0]] = cost




# n = 6
# INF = int(1e9)
# start = 1
# graph = [
#     [],
#     [[2, 2], [3, 5], [4, 1]],
#     [[3, 3], [4, 2]],
#     [[2, 3], [6, 5]],
#     [[3, 3], [5, 1]],
#     [[3, 1], [6, 2]]
# ]
# distance = [INF]*(n+1)
# visited = [False]*(n+1)

# dijkstra(start)
# print(distance)


# 2. 개선된 다익스트라 알고리즘

import heapq
n = 6
INF = int(1e9)
graph = [
    [],
    [[2, 2], [3, 5], [4, 1]],
    [[3, 3], [4, 2]],
    [[2, 3], [6, 5]],
    [[3, 3], [5, 1]],
    [[3, 1], [6, 2]],
    []
]
visited = [False]*(n+1)
distance = [INF]*(n+1)
start = 1
q = []
heapq.heappush(q, (0, start))

while q:
    dist, now = heapq.heappop(q)
    # print("now : ", now, " dist : ", dist)
    if dist > distance[now]:
        # print("이미 처리된 적 있음")
        # print(distance[now])
        continue
    if visited[now] == False:
        visited[now] = True
        for new in graph[now]:
            cost = new[1] + dist
            if cost < distance[new[0]]:
                distance[new[0]] = cost
                heapq.heappush(q, (cost, new[0]))
# print(distance)
    




# 3. 플로이드 워셜 알고리즘

n = 4
INF = int(1e9)
# graph = [[0]*(n+1)]*(n+1)
# for i in range(7):
#     a, b, c = map(int, input("입력 : ").split())
#     print(a, b, c)
# print(graph)

graph = [
    [0, 0, 0, 0, 0],
    [0, 0, 4, INF, 6],
    [0, 3, 0, 7, INF],
    [0, 5, INF, 0, 4],
    [0, INF, INF, 2, 0]
]

for i in range(1, 5):
    checks = []
    for j in range(1, 5):
        if i != j:
            checks.append(j)
    for check1 in checks:
        for check2 in checks:
            if check1 != check2:
                print("확인 : ", check1, check2)
                print("거쳐감 : ", i)
                graph[check1][check2] = min(graph[check1][check2], graph[check1][i]+graph[i][check2])
    print(" ")

for k in graph:
    print(k)