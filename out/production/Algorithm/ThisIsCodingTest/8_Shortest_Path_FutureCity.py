


# 실전문제 1. 미래도시
# 회사들이 연결되어 있으면 양방향 연결
# 정확히 1만큼의 시간으로 이동
# 1 - K - X
# 방문 판매원이 회사 사이를 이동하게 되는 최소시간을 계산


# import heapq
# INF = int(1e9)
# n, m = map(int, input("입력 : ").split())
# q = []
# for i in range(m):
#     con1, con2 = map(int, input("입력 : ").split())
#     heapq.heappush(q, (con1, con2))
# distance = [INF]*(n+1)


# start = 1
# def find_way(start):
#     distance[start] = 0
#     while q:
#         con1, con2 = heapq.heappop(q)
#         if con1 == start:
#             distance[con2] = 1
#         else:
#             if distance[con2] != INF:
#                 dist = distance[con1] + distance[con2]
#             else: 
#                 dist = distance[con1] + 1
#             if dist < distance[con2]:
#                 distance[con2] = dist

# find_way(start)
# print(distance)


        
INF = int(1e9)
n, m = map(int, input("입력 : ").split())

# 배열 초기화
array = [[INF]*(n) for i in range(n)]
for i in range(0, n):
    array[i][i] = 0

# 간선 정보
for i in range(m):
    a,b = map(int, input("입력 : ").split())
    array[a-1][b-1] = 1
    array[b-1][a-1] = 1


for k in range(0, n):
    for a in range(0, n):
        for b in range(0, n):
            array[a][b] = min(array[a][b], array[a][k] + array[k][b])

print(array[0][4] + array[4][3])


# 내 생각 정리
# 1. 이 문제는 우선 전체에서 전체를 찾는 것이 중요하다.
# 이유는 결과적으로 봤을때, 1에서 x, x에서 k등 한가지 기준이 아닌 전체에서 전체이기 때문이다.
# 따라서 플로이드 워셜 알고리즘을 사용해야 한다.
# 2. 문제를 파악하는게 중요하다. 처음에 문제 파악하지 않고 옳지 않은 방향으로 가버렸다.
