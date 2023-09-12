

# 인구 이동

# 그래프 정보
l1 = 5
r1 = 10
graph1 = [
    [10, 15, 20],
    [20, 30, 25],
    [40, 22, 10]
]
l2 = 40
r2 = 50
graph2 = [
    [50, 30],
    [20, 40]
]
l3 = 20
r3 = 50
graph3 = [
    [50, 30],
    [30, 40]
]
n4 = 4
l4 = 10
r4 = 50
graph4 = [
    [10, 100, 20, 90],
    [80, 100, 60, 70],
    [70, 20, 30, 40],
    [50, 20, 100, 10]
]

# 답안

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
result = 0

from collections import deque
def process(x, y, index):
    united = []
    united.append((x, y))
    q = deque()
    q.append((x, y))
    union[x][y] = index
    summary = graph4[x][y]
    count = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n4 and 0 <= ny < n4 and union[nx][ny] == -1:
                if l4 <= abs(graph4[nx][ny] - graph4[x][y]) <= r4:
                    q.append((nx, ny))
                    union[nx][ny] = index
                    summary += graph4[nx][ny]
                    count += 1
                    united.append((nx, ny))
    for i,j in united:
        graph4[i][j] = summary // count
    return count


total_count = 0
while True:
    union = [[-1]*n4 for _ in range(n4)]
    index = 0

    for i in graph4:
        print(i)
    print(" ")

    for i in range(n4):
        for j in range(n4):
            if union[i][j] == -1:
                process(i, j, index)
                index += 1
    if index == n4*n4:
        break
    total_count += 1

print(total_count)









# 나의 답변

# graph4 = [
#     [10, 100, 20, 90],
#     [80, 100, 60, 70],
#     [70, 20, 30, 40],
#     [50, 20, 100, 10]
# ]

# # 인접마다 차이 구하고 인접 리스트 만들기
# def make_closed(graph, l, r):
#     closed = [[False for i in range(len(graph4))] for i in range(len(graph4))]
#     for i in range(len(graph)):
#         for j in range(len(graph)-1):
#             if l <= abs(graph[i][j] - graph[i][j+1]) <= r:
#                 closed[i][j] = True
#                 closed[i][j+1] = True

#     for i in range(len(graph)):
#         for j in range(len(graph)-1):
#             if l <= abs(graph[j][i] - graph[j+1][i]) <= r:
#                 closed[j][i] = True
#                 closed[j+1][i] = True
#     return closed


# from collections import deque
# dx = [-1, 0, 1, 0]
# dy = [0, -1, 0, 1]

# def bfs(x, y, closed, n):
#     q = deque()
#     q.append((x, y))
#     result = []
#     while q:
#         x, y = q.popleft()
#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]
#             if 0 <= nx < n and 0 <= ny < n and closed[nx][ny] == True:
#                 closed[nx][ny] = False
#                 result.append((nx, ny))
#                 q.append((nx, ny))
#     return result

# def change_graph(graph, l, r, n):
#     len_closed = 0
#     result = 0

#     # 인접 관계 구하기
#     closed = make_closed(graph, l, r)

#     # bfs로 그룹 만들기
#     results = []
#     for a in range(len(graph)):
#         for b in range(len(graph)):
#             if closed[a][b] == True:
#                 results.append(bfs(a, b, closed, n))
#     if len(results) == 0:
#         return False

#     sums = []
#     lengths = []
#     for result in results:
#         sum = 0
#         length = 0
#         for x, y in result:
#             sum += graph[x][y]
#             length += 1
#         sums.append(sum)
#         lengths.append(length)



#     change_to = []
#     for i in range(len(sums)):
#         change_to.append(sums[i]//lengths[i])

#     index = 0
#     for result in results:
#         for x,y in result:
#             graph[x][y] = change_to[index]
#         index += 1

#     for k in graph:
#         print(k)
#     print(" ")

#     return True

# print("초기 함수")
# for i in graph4:
#     print(i)
# print("")

# final = True
# while final:
#     final = change_graph(graph4, l4, r4, n4)




