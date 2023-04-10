


# 미로 탈출
from collections import deque
def bfs(array, visited, start):
    visited[start[0]][start[1]] = True
    queue = deque()
    queue.append(start)

    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if next_x < 0 or next_x >= len(array) or next_y < 0 or next_y >= len(array[0]):
                continue
            if visited[next_x][next_y] == False and array[next_x][next_y] == 1:
                visited[next_x][next_y] = True
                array[next_x][next_y] = array[x][y] + 1
                queue.append([next_x, next_y])
                if next_x == len(array)-1 and next_y == len(array[0])-1:
                    return 1

array = [
    [1, 0, 1, 0, 1, 0],
    [1, 1, 1, 1, 1, 1],
    [0, 0, 0, 0, 0, 1],
    [1, 1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1, 1]
]
start = [0, 0]
visited = [[False]*len(array[0]) for _ in range(len(array))]
bfs(array, visited, start)
print(array[len(array)-1][len(array[0])-1])
for i in array:
    print(i)