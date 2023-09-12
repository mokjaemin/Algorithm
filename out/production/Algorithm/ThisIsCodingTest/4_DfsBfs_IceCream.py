

# 실전문제 1. 음료수 얼려먹기
# NxM 크기의 얼음틀
# 구멍이 뚫려있는 부분 0
# 칸막이가 존재하는 부분 1
# 구멍이 뚫려있는 부분끼리 상, 하, 좌, 우로 붙어있는 경우 서로 연결되어 있는 것으로 간주

# 입력 조건
# 세로길이, 가로길이 입력
# 세로 길이에 따른 얼음 틀 입력

# 출력 조건
# 한번에 만들 수 있는 아이스크림의 개수를 출력

# 답안

# 맵 크기 입력 받기
# n, m = map(int, input("입력 : ").split(" "))

# 맵 입력 받기
# graph = []
# for i in range(n):
#     graph.append(list(map(int, input("입력 : "))))

# def dfs(x, y):
#     # 범위가 넘어가는지 확인
#     if x <= -1 or x >= n or y <= -1 or y >= m:
#         return False
    
#     if graph[x][y] == 0:
#         graph[x][y] = 1
#         dfs(x-1, y)
#         dfs(x+1, y)
#         dfs(x, y-1)
#         dfs(x, y+1)
#         return True
#     return False

# result = 0
# for i in range(n):
#     for j in range(m):
#         if dfs(i, j) == True:
#             result += 1

# print(result)

# 아이디어
# 1. 특정한 지점의 주변 상,하,좌,우를 살펴본 뒤에 주변 지점 중에서 값이 0이면서
# 아직 방문하지 않은 지점이 있다면 해당 지점을 방문한다.
# 2. 방문한 지점에서 다시 상,하,좌,우를 살펴보면서 방문을 다시 진행하면,
# 연결된 모든 지점을 방문할 수 있다.
# 3. 1~2번의 과정을 모든 노드에 반복하며 방문하지 않은 지점의 수를 센다.


# 다시 한번 작성해보기
# x, y = map(int, input("입력 : ").split(" "))
# graph = []
# for i in range(x):
#     graph.append(list(map(int, input("입력 : "))))

# def dfs(i, j):
#     if(i>=0 and i<=x-1 and j>=0 and j<=y-1):
#         if(graph[i][j] == 0):
#             graph[i][j] = 1
#             dfs(i+1, j)
#             dfs(i-1, j)
#             dfs(i, j+1)
#             dfs(i, j-1)
#             return 1
#     return 0

# result = []
# for i in range(x):
#     for j in range(y):
#         result.append(dfs(i, j))
#         print(result)


# 코드 분석

# 1. map의 구조 받기
n, m = map(int, input("입력 : ").split(" "))

# 2. map의 데이터 받기
graph = []
for i in range(n):
    graph.append(list(map(int, input("입력 : "))))

# 3. 문제 해결
# 이용 - DFS
# 특징 - 선입 후출, 깊이 우선 탐색(최대한 깊은 노드 우선으로 탐색)
# 동작 - 최상단 스택의 인접노드 중 방문하지 않은 가장 인덱스가 낮은 인접노드부터 순서대로 방문 후 방문처리

# 활용
# 0 뭉텅이가 아이스크림 뭉텅이인데, 근처 인접 노드부터 스택에 넣어가며 방문처리
# 방문처리는 1로 변경
def dfs(i, j):
    # 해당 범위를 넘어가면 return 처리 해버림
    if(i>=0 and i<=n-1 and j>=0 and j<=m-1):
        # 해당 그래프 값이 1이면 나가버림
        if(graph[i][j] == 0):
            # 1처리해서 방문처리
            graph[i][j] = 1
            # 여기서 값이 모든 간에 결국 메인에서 return 되는 값은 1
            dfs(i+1, j)
            dfs(i-1, j)
            dfs(i, j+1)
            dfs(i, j-1)
            return 1
    return 0

result = []
for i in range(n):
    for j in range(m):
        result.append(dfs(i, j))
        print(result)


