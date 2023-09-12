

# 경쟁적 전염

from collections import deque

# 기본 정보 
n = 4
k = 4
graph = [
    [2, 0, 0, 1],
    [0, 0, 0, 0],
    [3, 0, 0, 0],
    [0, 0, 0, 0]
]
s = 2 
result_x, result_y = 3, 2

# 바이러스를 담을 큐
queue = deque()

# 바이러스 배열 생성
viruses = []
for i in range(n):
    for j in range(n):
        if graph[i][j] != 0:
            viruses.append(graph[i][j])
viruses.sort()

# 해당 바이러스를 큐에 담으면서 큐 초기화
for virus in viruses:
    for i in range(n):
        for j in range(n):
            if graph[i][j] == virus:
                queue.append([i, j, virus])

# 카운트 (초)
count = 0

# 방향
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

# 바이러스 퍼짐
def bfs(x, y, virus):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < n:
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                queue.append([nx, ny, virus])


# 해당 초에 종료
while count != s:
    now =[]
    while queue:
        now.append(queue.popleft())

    print("now : ", now)
    for i in now:
        x, y, virus = i
        bfs(x, y, virus)          

    count += 1
    print("count : ", count)

    for i in graph:
        print(i)
    print(" ") 


print("result : ", graph[result_x-1][result_y-1])