


# 정확한 순위

INF = int(1e9)
n = 6
graph = [
    [0, 0, 0, 0, 0, 0, 0],
    [0, 0, INF, INF, INF, 1, INF],
    [0, INF, 0, INF, INF, INF, INF],
    [0, INF, INF, 0, 1, INF, INF],
    [0, INF, 1, INF, 0, INF, 1],
    [0, INF, 1, INF, 1, 0, INF],
    [0, INF, INF, INF, INF, INF, 0],
]
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])
for g in graph:
    print(g)
count = []
for a in range(1, n+1):
    for b in range(1, n+1):
        if graph[a][b] == INF:
            if graph[b][a] == INF:
                count.append(a)
                count.append(b)
result = 0
for i in range(1, n+1):
    if i not in count:
        result += 1
print(result)
