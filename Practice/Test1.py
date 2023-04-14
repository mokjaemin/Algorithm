

# 미로 탐색 - 백준

from collections import deque

n, m = map(int, input().split())
array = [[] for _ in range(n)]
for i in range(n):
    check = []
    check.append(input())
    for j in range(m):
        array[i].append(int(check[0][j]))


dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

q = deque()
q.append([0, 0, 1])
array[0][0] = 0

while q:
    x, y, cost = q.popleft()
    for i in range(4):
        next_x = x + dx[i]
        next_y = y + dy[i]
        if next_x < 0 or next_x >= n or next_y < 0 or next_y >= m:
            continue
        if array[next_x][next_y] == 1:
            array[next_x][next_y] = cost+1
            q.append([next_x, next_y, cost+1])

print(array[n-1][m-1])

