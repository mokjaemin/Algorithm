


# 플로이드
INF = int(1e9)
n = 5
m = 14

# 그래프 초기화
graph = [[INF]*(n+1) for _ in range(n+1)]

# 자기 자신으로 오는 구간 0 처리
for i in range(1, n+1):
    graph[i][i] = 0

# 버스 입력받아 최솟값 입력
for i in range(m):
    a, b, c = map(int, input("입력 : ").split())
    graph[a][b] = min(graph[a][b], c)


for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


for a in graph:
    print(a)