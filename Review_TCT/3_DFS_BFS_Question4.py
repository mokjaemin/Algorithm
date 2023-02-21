


# 연구소




# dfs부터 수정!!!!!!!!!!!!!!!!!!!!!!!!



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

def dfs(x, y):
    if x+1 < n:
        if graph[x+1][y] == 0:
            graph[x+1][y] = 2
            dfs(x+1, y)
    if x-1 >= 0:
        if graph[x-1][y] == 0:
            graph[x-1][y] = 2
            dfs(x-1, y)
    if y+1 < m:
        if graph[x][y+1] == 0:
            graph[x][y+1] = 2
            dfs(x, y+1)
    if y-1 >= 0:
        if graph[x][y-1] == 0:
            graph[x][y-1] = 2
            dfs(x, y-1)

# 결과 모음
result = []


# 벽을 놓을 수 있는 모든 조합
walls = list(combinations(emp, 3))
# i = [[1, 0], [0, 1], [3, 5]]


for i in walls:
    # 벽 생성
    for j in i:
        x, y = j
        graph[x][y] = 1

    # 최초의 빈공간 찾기
    for k in range(n):
        for u in range(m):
            if graph[k][u] == 2:
                dfs(k, u)

    # 그래프 출력
    count = 0 
    for i in range(len(graph)):
        for m in graph[i]:
            if m == 0:
                count += 1
    result.append(count)

    # 그래프 재설정
    graph = [
        [2, 0, 0, 0, 1, 1, 0],
        [0, 0, 1, 0, 1, 2, 0],
        [0, 1, 1, 0, 1, 0, 0],
        [0, 1, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 1, 1],
        [0, 1, 0, 0, 0, 0, 0],
        [0, 1, 0, 0, 0, 0, 0]
    ]

print(result)
