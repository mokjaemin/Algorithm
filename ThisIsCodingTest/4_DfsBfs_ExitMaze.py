

# 실전 문제 2. 미로 탈출
# 시작점 (1, 1) - 즉 (0, 0)에서 시작한다.
# 괴물 0, 괴물 없는 부분 1(통로)
# 출구는 (N, M)에 위치
# 미로 탈출을 위한 움직의 최소 칸

# from collections import deque
# n, m = map(int, input("입력 : ").split(" "))
# graph = []
# for i in range(n):
#     graph.append(list(map(int, input("입력 : "))))
# def bfs(x, y, i):
#     if(x <= -1 or x >= n or y <= -1 or y >= m):
#         return 1
#     else:
#         if(y+1 <= m-1):
#             if(graph[x][y+1] == 1):
#                 graph[x][y+1] = i
#                 i += 1
#                 bfs(x, y+1, i)
#         if(x+1 <= n-1):
#             if(graph[x+1][y] == 1):
#                 graph[x+1][y] = i
#                 i += 1
#                 bfs(x+1, y, i)
#         if(x-1 >= 0):
#             if(graph[x-1][y] == 1):
#                 graph[x-1][y] = i
#                 i += 1
#                 bfs(x-1, y, i)
#         if(y-1 >= 0):
#             if(graph[x][y-1] == 1):
#                 graph[x][y-1] = i
#                 i += 1
#                 bfs(x, y-1, i)
#     return 1

# bfs(0, 0, 2)
# print(graph)
# print(graph[n-1][m-1])

# 모순
# 1. 우선, 첫번째 인덱스도 i처리 해버림
# 해결 : 이건 밑에서도 그렇게 됨
# 2. i가 올라가다보면 다른 way처리할때 올라간 상태를 가져와 바꿔버림
# 해결 : 재귀함수를 사용하지 않음, deque를 사용, 시작점을 기준으로 해서 더해버림
# 즉, 시작점 값을 더함



# 답안
from collections import deque

# 입력
n, m = map(int, input("입력 : ").split())
graph = []
for i in range(n):
    graph.append(list(map(int, input("입력 : "))))

# 이동할 네 방향 정리(상,하,좌,우)
# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]

# # bfs 함수 정의
# def bfs(x, y):
#     quene = deque()
#     quene.append((x, y))
#     # quene이 빌때까지 실행
#     while(quene):
#         # 먼저 하나 제거하고 담아둠
#         x, y = quene.popleft()
#         for i in range(4):
#             # 방향마다 이동
#             nx = x+dx[i]
#             ny = y+dy[i]
#             # 미로 범위를 넘어가면 무시
#             if nx < 0 or ny < 0 or nx >= n or ny >= m:
#                 # continue시 for문 나가버림
#                 continue
#             # 벽인 경우 무시
#             if graph[nx][ny] == 0:
#                 continue
#             # 해당 경로를 처음 방문하는 경우에만 최단 거리 기록
#             if graph[nx][ny] == 1:
#                 graph[nx][ny] = graph[x][y] + 1
#                 quene.append((nx, ny))
#                 print(quene)
#     return graph[n-1][m-1]

# print(bfs(0,0))
# print(graph)



# 다시 작성
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    # quene은 bfs 안에 넣어 줘야함
    quene = deque()
    quene.append((x, y))
    while(quene):
        x, y = quene.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if(nx < 0 or nx > n-1 or ny < 0 or ny > m-1):
                continue
            if(graph[nx][ny] == 0):
                continue
            if(graph[nx][ny] == 1):
                graph[nx][ny] = graph[x][y] + 1
                quene.append((nx, ny))
                print(quene)
    return graph[n-1][m-1]
print(bfs(0,0))
print(graph)
            