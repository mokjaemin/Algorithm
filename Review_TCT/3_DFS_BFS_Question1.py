

# 실전문제 1. 음료수 얼려 먹기

from collections import deque
n = 4
m = 8
queue = deque()
count = 0
graph = [
    [0, 0, 1, 1, 0, 0, 1, 0],
    [0, 0, 0, 1, 1, 0, 1, 0],
    [1, 1, 1, 1, 1, 1, 0, 1],
    [0, 0, 0, 0, 0, 1, 0, 1]
]
dx = [-1, 1, 0, 0] # 상하좌우 
dy = [0, 0, -1, 1]
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            queue.append([i, j])
            graph[i][j] = 2
            count += 1
        while queue:
            now_x, now_y = queue.popleft()
            for k in range(4):
                if 0 <= now_x+dx[k] <= n-1 and 0 <= now_y+dy[k] <= m-1:
                    if graph[now_x+dx[k]][now_y+dy[k]] == 0:
                        queue.append([now_x+dx[k], now_y+dy[k]])
                        graph[now_x+dx[k]][now_y+dy[k]] = 2
print(count)


# 답안 DFS 이용

graph = [
    [0, 0, 1, 1, 0, 0, 1, 0],
    [0, 0, 0, 1, 1, 0, 1, 0],
    [1, 1, 1, 1, 1, 1, 0, 1],
    [0, 0, 0, 0, 0, 1, 0, 1]
]

def dfs(x, y):
    if x<=-1 or x>=n or y<=-1 or y>=m:
        return False
    if graph[x][y] == 0:
        graph[x][y] = 1
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True
    return False

result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j):
            result += 1
print(result)