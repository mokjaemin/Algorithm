



# 특정 거리의 도시 찾기

from collections import deque
n = 4 # 노드 수
m = 3 # 도로의 개수
k = 2 # 찾고자 하는 거리
x = 1 # 시작 노드
distance = [0]*(n+1)
distance[0] = 9999999
graph = [
    [1, 2],
    [1, 3],
    [2, 3],
    [2, 4]
]
# 특정 노드까지의 거리
# ex) distance[1] -> 시작노드와 노드1까지의 최단 거리
queue = deque()
queue.append(x)
length = 1
while queue:
    now = queue.popleft()
    for i in graph:
        if i[0] == now:
            if distance[i[1]] == 0:
                distance[i[1]] = distance[now]+1
            queue.append(i[1])
    length += 1
print(distance)
for i in range(len(distance)):
    if distance[i] == k:
        print(i, end=" ")
print(" ")