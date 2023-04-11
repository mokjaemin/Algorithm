

# 인구 이동

# 답지 볼 것


n = 4
min_value = 10
max_value = 50
graph = [
    [10, 100, 20, 90],
    [80, 100, 60, 70],
    [70, 20, 30, 40],
    [50, 20, 100, 10]
]
# graph = [
#     [10, 15, 20],
#     [20, 30, 25],
#     [40, 22, 10]
# ]
# graph = [
#     [50, 30],
#     [20, 40]
# ]

from collections import deque
n, min_value, max_value = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))


dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
final_count = 0

while(1):

    again = False
    count = 0 

    # for i in graph:
    #     print(i)
    # print(" ")

    union = []
    united = [[0]*n for _ in range(n)]

    for x in range(n):
        for y in range(n):

            if united[x][y] != 0:
                continue

            union = []
            q = deque()

            q.append([x, y])
            union.append([x, y])
            summary = graph[x][y]
            num = 1

            count += 1
            united[x][y] = count

            while q:
                x, y = q.popleft()
                for i in range(4):
                    next_x = x + dx[i]
                    next_y = y + dy[i]
                    if next_x < 0 or next_x >= n or next_y < 0 or next_y >= n:
                        continue
                    if [next_x, next_y] in union:
                        continue
                    if united[next_x][next_y] != 0:
                        continue
                    if min_value <= abs(graph[next_x][next_y] - graph[x][y]) <= max_value:
                        union.append([next_x, next_y])
                        q.append([next_x, next_y])
                        united[next_x][next_y] = count
                        summary += graph[next_x][next_y]
                        num += 1
                        again = True
            
            for index in union:
                graph[index[0]][index[1]] = summary//num

    if not again:
        print(final_count)
        break

    final_count += 1




