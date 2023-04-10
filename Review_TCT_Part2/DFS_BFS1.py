



# 음료수 얼려먹기

def dfs(array, visited, start):
    x = start[0]
    y = start[1]
    visited[x][y] = True

    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]

    for i in range(4):
        next_x = x+dx[i]
        next_y = y+dy[i]
        if 0 <= next_x < len(array) and 0 <= next_y < len(array[0]):
            if visited[next_x][next_y] == False and array[next_x][next_y] == 0:
                dfs(array, visited, [next_x, next_y])
    return 1

from collections import deque
def bfs(array, visited, start):

    queue = deque()
    queue.append(start)
    visited[start[0]][start[1]] = True

    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            next_x = x+dx[i]
            next_y = y+dy[i]
            if 0 <= next_x < len(array) and 0 <= next_y < len(array[0]):
                if visited[next_x][next_y] == False and array[next_x][next_y] == 0:
                    visited[next_x][next_y] = True
                    queue.append([next_x, next_y])
    return 1



array = [
    [0, 0, 1, 1, 0],
    [0, 0, 0, 1, 1],
    [1, 1, 1, 1, 1],
    [0, 0, 0, 0, 0]
]
visited = [[False]*len(array[0]) for _ in range(len(array))]
result = 0
for i in range(len(array)):
    for j in range(len(array[0])):
        if visited[i][j] == False and array[i][j] == 0:
            result += dfs(array, visited, [i, j])
print(result)