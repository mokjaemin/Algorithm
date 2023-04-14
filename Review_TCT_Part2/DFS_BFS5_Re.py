

# 경쟁적 전염

from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

n, k = map(int, input().split())
graph = []
vires_pos = []

for i in range(n):
    graph.append(list(map(int,input().split())))
    for j in range(n):
        if graph[i][j] != 0:
            vires_pos.append([graph[i][j], 0, i, j])

target_s, target_x, target_y = map(int, input().split())
vires_pos.sort()
queue = deque(vires_pos)

while queue:
    virus, s, x, y = queue.popleft()
    if s >= target_s:
        break
    for i in range(4):
        next_x = x + dx[i]
        next_y = y + dy[i]
        if next_x < 0 or next_x >= n or next_y < 0 or next_y >= n:
            continue
        if graph[next_x][next_y] == 0:
            graph[next_x][next_y] = virus
            queue.append([virus, s+1, next_x, next_y])

for i in graph:
    print(i)
print(graph[target_x-1][target_y-1])

    
