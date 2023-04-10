

# 경쟁적 전염
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
from collections import deque

def bfs(array, n, k, s, final_x, final_y, queue):
    while queue:
        now = queue.popleft()
        if now[3] == s:
            return array[final_x-1][final_y-1]
        for i in range(4):
            next_x = now[0] + dx[i]
            next_y = now[1] + dy[i]
            if next_x < 0 or next_x >= n or next_y < 0 or next_y >= n:
                continue
            if array[next_x][next_y] == 0:
                array[next_x][next_y] = now[2]
                queue.append([next_x, next_y, now[2], now[3]+1])
    return array[final_x-1][final_y-1]
            

n, k = map(int, input().split())
data = []
array = []
for i in range(n):
    array.append(list(map(int, input().split())))
    for j in range(n):
        if array[i][j] != 0:
            data.append((i, j, array[i][j], 0))
data.sort()
queue = deque(data)
s, final_x, final_y = map(int, input().split())
print(bfs(array, n, k, s, final_x, final_y, queue))