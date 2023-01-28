

# 최단 경로
# 가장 짧은 경로를 찾는 알고리즘

# 종류 : 다익스트라(데이크스트라), 폴로이드 워셜, 벨만 포드

# 1. 다익스트라 최단 경로 알고리즘
# 특정 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘
# '음의 간선'이 없을 때 정상적으로 동작
# 과정
# 1. 출발 노드를 설정
# 2. 최단 거리 테이블을 초기화
# 3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택
# 4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신
# 5. 3번과 4번 과정 반복
# 구현법
# 1. 구현하기 쉽지만 느리게 동작하는 코드
# 2. 구현하기에 조금 더 까다롭지만 빠르게 동작하는 코드 (V)


# 방법 1. 간단한 다익스트라 알고리즘
# 시간 복잡도 : O(V**2) (V-노드의 개수) - 가장 가까운 노드 찾기 x 다익스트라 알고리즘
# 원리 : 각 노드에 대한 최단 거리를 담는 1차원 리스트 선언 후, 단계마다 방문하지 않은
# 노드 중에서 최단거리가 가장 짧은 노드를 선택하기 위해 매 단계마다 1차원 리스트의 모든 원소를 확인

# 코드
# import sys
# input = sys.stdin.readline

# # 노드, 간선, 시작점
# n, m = map(int, input().split())
# start = int(input())
# # 무한 정의
# INF = int(1e9)
# distance = [INF]*(n+1)
# visited = [False]*(n+1)
# array = [[] for i in range(n+1)]
# for i in range(m):
#     a, b, c = map(int, input().split())
#     array[a].append((b, c))

# def get_smallest_node():
#     index = 0
#     min_value = INF
#     for i in range(1, n+1): # 모든 노드를 돌며
#         # 방문하지 않았고 시작 노드와 거리가 가장 작은 노드 선택
#         if distance[i] < min_value and not visited[i]:
#             min_value = distance[i]
#             index = i
#     return index


# def dijkstra(start):
#     visited[start] = True
#     distance[start] = 0
#     for i in array[start]:
#         distance[i[0]] = i[1]
#     for i in range(n-1): # 노드의 개수만큼 반복(노드를 다 돌면 끝이기 때문에, start 노드 재외)
#         now = get_smallest_node()
#         visited[now] = True
#         for j in array[now]: # 지금 해당 노드와 연결된 노드 정보를 불러온다.
#             cost = distance[now] + j[1] # 여기까지 오는 비용 + 목적지까지 가는 비용
#             if cost < distance[j[0]]:
#                 distance[j[0]] = cost        
    

# dijkstra(start)

# for i in range(1, n+1):
#     if distance[i] == INF:
#         print("INFINTY")
#     else:
#         print(distance[i])


# 방법 2. 개선된 다익스트라 알고리즘
# 가장 거리가 짧고 방문하지 않는 노드를 찾는 과정을 단축
# 힙 자료구조(우선순위가 가장 높은 데이터를 가장 먼저 삭제)를 사용해 구현
# 시간 복잡도 : O(Nlog(N)) -> 힙자료구조를 사용하면 가장 짧은 거리 찾는데 log(N)

# (+)
# 힙은 값이 낮은 순으로 나오는 최소힙을 기본적으로 사용, 최대힙 사용시 -를 붙여서 구하고 다시 -


# 코드
# import heapq
# import sys
# input = sys.stdin.readline
# INF = int(1e9)

# n, m = map(int, input().split())
# start = int(input())
# distance = [INF]*(n+1)
# graph = [[] for i in range(n+1)]

# for i in range(m):
#     a, b, c = map(int, input().split())
#     graph[a].append((b, c))

# def dijkstra(start):
#     q = []
#     distance[start] = 0
#     heapq.heappush(q, (0, start))
#     while q:
#         dist, now = heapq.heappop(q)
#         # 이미 처리된적 있다면 무시, (0 < 0 -> False)
#         if distance[now] < dist:
#             continue
#         for i in graph[now]: # 현재 노드와 연결된 노드와, 간선
#             cost = dist + i[1] # 현재노드와 시작노드와의 거리 + 목적노드와 현재노드의 거리
#             if cost < distance[i[0]]: # 원래 기존 목적노드와 시작노드와의 거리보다 작으면
#                 distance[i[0]] = cost # 변경
#                 heapq.heappush(q, (cost, i[0])) # 변경 후 힙에





# 2. 플로이드 워셜 알고리즘
# 모든 지점에서 모든 지점까지 최단 거리를 구하는 경우
# 시간 복잡도 : O(N**3)

# 코드
# 노드와 간선 수 받기
INF = int(1e9)
n, m = map(int, input("입력 : ").split())

# 배열 초기화
array = [[INF]*(n) for i in range(n)]
for i in range(0, n):
    array[i][i] = 0

# 간선 정보
for i in range(m):
    a,b,c = map(int, input("입력 : ").split())
    array[a-1][b-1] = c


for k in range(0, n):
    for a in range(0, n):
        for b in range(0, n):
            array[a][b] = min(array[a][b], array[a][k] + array[k][b])

print(array)