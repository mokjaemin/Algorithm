


# 미래도시

n = 4
k = 4
x = 3
INF = int(1e9)

graph = [
    [0, 0, 0, 0, 0, 0],
    [0, 0, 1, 1, 1, INF],
    [0, 1, 0, INF, 1, INF],
    [0, 1, INF, 0, 1, 1],
    [0, 1, 1, 1, 0, 1],
    [0, INF, INF, 1, 1, 0],
]

graph = [
    [0, 0, 0, 0, 0],
    [0, 0, INF, 1, INF],
    [0, INF, 0, INF, 1],
    [0, 1, INF, 0, INF],
    [0, INF, 1, INF, 0],
]

for i in range(1, n+1):
    for j in range(1, n+1):
        for a in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][a] + graph[a][j])
for b in graph:
    print(b)

print(graph[1][k] + graph[k][x])