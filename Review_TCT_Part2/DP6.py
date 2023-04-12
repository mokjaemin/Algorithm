


# 정수 삼각형


# n = 5
# graph = [
#     [7],
#     [3, 8],
#     [8, 1, 0],
#     [2, 7, 4, 4],
#     [4, 5, 2, 6, 5]
# ]

n = int(input())
m = int(input())
graph = []
graph.append([m])
for i in range(1, n):
    graph.append(list(map(int, input().split())))

dy = [-1, 0]
for x in range(1, n):
    for y in range(len(graph[x])):
        max_value = 0
        for i in range(2):
            before_x = x-1
            before_y = y+dy[i]
            if before_y < 0 or before_y >= len(graph[x-1]):
                continue
            max_value = max(max_value, graph[before_x][before_y])
        graph[x][y] = max_value + graph[x][y]

result = 0
for i in range(len(graph[-1])):
    result = max(result, graph[-1][i])
print(result)
