


# 경쟁적 전염 답안

from collections import deque

n, k = map(int, input().split())

graph = []
# 바이러스를 담을 리스트
data = []

for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(n):
        if graph[i][j] != 0:
            data.append((graph[i][j], 0, i, j))

data.sort()
q = deque(data)

target_s, target_x, targer_y = map(int, input().split())

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

while q:
    virus, s, x, y = q.popleft()
    if s == target_s:
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                q.append((virus, s+1, nx, ny))

print(graph[target_x-1][targer_y-1])