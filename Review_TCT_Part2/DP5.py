


# 금광


t = int(input())
final_result = []
for i in range(t):
    n, m = map(int, input().split())
    test = list(map(int, input().split()))

    graph = []
    index = 0
    for i in range(n):
        graph.append(test[index:index+m])
        index += m

    dx = [-1, 0, 1]
    max_value = 0

    while(1):
        result = 0
        for y in range(1, m):
            for x in range(n):
                max_value = 0
                for i in range(3):
                    before_x = x + dx[i]
                    before_y = y + -1
                    if before_x < 0 or before_x >= n or before_y < 0:
                        continue
                    max_value = max(max_value, graph[before_x][before_y])
                graph[x][y] = max_value + graph[x][y]
            result = max(result, graph[x][m-1])
        final_result.append(result)
        break
print(final_result)


        


