


# 연구소

# 2가 왜 안퍼지는지 해결하지 못함...


from itertools import combinations


n = 7
m = 7
graph = [
    [2, 0, 0, 0, 1, 1, 0],
    [0, 0, 1, 0, 1, 2, 0],
    [0, 1, 1, 0, 1, 0, 0],
    [0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 1, 1],
    [0, 1, 0, 0, 0, 0, 0],
    [0, 1, 0, 0, 0, 0, 0]
]

# 벽을 놓을 위치들 
emp = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            emp.append([i, j])


# 방향
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


# dfs
def dfs(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < m:
            if graph[nx][ny] == 0:
                graph[nx][ny] = 2
                dfs(nx, ny)

# 결과 모음
result = []


# 벽을 놓을 수 있는 모든 조합
walls = list(combinations(emp, 3))


# for i in walls:
    # 그래프 재설정
i = [[0, 1], [0, 2], [1, 0]]
graph = [
    [2, 0, 0, 0, 1, 1, 0],
    [0, 0, 1, 0, 1, 2, 0],
    [0, 1, 1, 0, 1, 0, 0],
    [0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 1, 1],
    [0, 1, 0, 0, 0, 0, 0],
    [0, 1, 0, 0, 0, 0, 0]
]

# 벽 생성
for j in i:
    x, y = j
    graph[x][y] = 1

# 2찾고 퍼뜨리기
for a in range(n):
    for b in range(m):
        if graph[a][b] == 2:
            dfs(a, b)

# 그래프에서 0 찾기
count = 0 
for k in range(len(graph)):
    for m in graph[k]:
        if m == 0:
            count += 1
result.append(count)

# if count == 32:
#     print(i)
for a in range(len(graph)):
    print(graph[a])
    # break

print(max(result))
