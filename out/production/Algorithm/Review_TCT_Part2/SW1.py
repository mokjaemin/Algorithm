



# 미래도시


n, m = map(int, input().split())
INF = 1e9
graph = [[INF]*(n+1) for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1
x, k = map(int, input().split())

for i in range(1, n+1):
    graph[i][i] = 0


for a in range(1, n+1):
    for b in range(1, n+1):
        for c in range(1, n+1):
            graph[b][c] = min(graph[b][c], graph[b][a]+ graph[a][c])
for i in graph:
    print(i)

print(graph[1][k] + graph[k][x])