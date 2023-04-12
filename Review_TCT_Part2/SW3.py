



# 플로이드

INF = int(1e9)
n = int(input())
m = int(input())

graph = [[INF]*(n+1) for _ in range(n+1)]

for i in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)
    for i in graph:
        print(i)

for i in range(1, n+1):
    graph[i][i] = 0


for k in range(1, n+1):
    for x in range(1, n+1):
        for y in range(1, n+1):
            graph[x][y] = min(graph[x][k]+graph[k][y], graph[x][y])


for i in range(1, n+1):
    for j in range(1, n+1):
        print(graph[i][j], end=" ")
    print("")