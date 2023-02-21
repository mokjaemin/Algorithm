


# 실전문제 2. 미로 탈출

from collections import deque
n = 5
m = 6
queue = deque()
graph = [
    [1, 0, 1, 0, 1, 0],
    [1, 1, 1, 1, 1, 0],
    [0, 0, 0, 0, 1, 1],
    [1, 1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1, 1]
]
now = [0, 0]
queue.append(now)
dx = [-1, 1, 0, 0] # 상하좌우
dy = [0, 0, -1, 1]
graph[0][0] = 2

while queue:
    now = queue.popleft()
    for i in range(4):
        x, y = now
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx <= n-1 and 0 <= ny <= m-1:
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append([nx, ny])
    print(queue)
print(graph[n-1][m-1]-1)