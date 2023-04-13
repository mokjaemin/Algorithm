




# 정확한 순위

n = 6
m = 6
INF = int(1e9)
graph = [[INF]*(n+1) for _ in range(n+1)]

for i in range(1, n+1):
    graph[i][i] = 0

for i in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1


for k in range(1, n+1):
    for x in range(1, n+1):
        for y in range(1, n+1):
            graph[x][y] = min(graph[x][y], graph[x][k]+graph[k][y])


count = [True]*(n+1)
count[0] = False
for x in range(1, n+1):
    for y in range(1, n+1):
        if graph[x][y] == INF and graph[y][x] == INF:
            count[x] = False
            count[y] = False

for i in graph:
    print(i)

final_count = 0
for i in count:
    if i == True:
        final_count += 1
print(final_count)


