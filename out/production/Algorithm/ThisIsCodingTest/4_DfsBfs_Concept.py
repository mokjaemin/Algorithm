

# 그래프 기본
# 그래프 - 노드(정점), 간선으로 구성
# 그래프 탐색 - 하나의 노드를 시작으로 다수의 노드를 방문하는 것
# 두 노드가 간선으로 연결되어 있다 = 두 노드가 인접한다.
# 그래프의 표현 방식
# 1. 인접 행렬 : 2차원 배열로 그래프와 연결관계를 표현하는 방식
# 2. 인접 리스트 : 리스트로 그래프의 연결 관계를 표현하는 방식


# 데이터
# 노드1 - 7 - 노드0 - 5 - 노드2
#     0  1  2
#  0  0  7  5
#  1  7  0 INF
#  2  5 INF 0

# ex1 - 인접 행렬
INF = 999999999
graph = [
    [0, 7, 5],
    [1, 7, INF],
    [5, INF, 0]
]
# 2차원 배열에 각 노드가 연결된 형태를 기록하는 방식
# 연결되어 있지 않으면 INF(무한의 비용)으로 표시

# ex2 - 인접 리스트
# 모든 노드마다 연결된 노드에 대한 정보를 차례대로 연결하여 저장
# 노드0 - 노드1(7) - 노드2(5)
# 노드1 - 노드0(7)
# 노드2 - 노드0(5)
graph = [[] for _ in range(3)]
graph[0].append((1, 7)) # 노드인덱스, 간선
graph[0].append((2, 5))
graph[1].append((0, 7))
graph[2].append((0, 5))
# print(graph)
# 파이썬에서는 2차원으로 표시


# 메모리와 속도 비교
# 1. 메모리
# 인접 행렬 < 인접 리스트
# 인접 행렬은 노드 개수가 많을수록 메모리 많이 차지
# 2. 속도
# 인접 행렬 > 인접 리스트
# 특정한 두 노드가 연결되어 있는지에 대한 정보를 얻는 속도가 느리다. 연결된 데이터를 하나씩 확인해야하므로



# 1. DFS (Depth-First Search)
# 깊이 우선 탐색, 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘

# DFS 응용
# 시간 복잡도 : O(N) -> 데이터 : N
# DFS는 재귀함수 구현시 용이
# DFS는 숫자가 낮은 노드부터 탐색
# 최대한 멀리 있는 노드를 우선으로 탐색하는 방식으로 동작
# 자료형식 : 스택(선입후출)


# DFS의 동작 과정
# 1. 탐색 시작 노드를 스텍에 삽입하고 방문 처리를 한다.
# 2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문처리를한다.
# 방문하지 않은 노드가 없으면 스택에서 최상단 노드를 꺼낸다. (웬만하면 번호가 낮은순으로 선택)
# 3. 2번 과정을 더 이상 수행할 수 없을때까지 반복한다.
# 최상단 노드 - 방금 방문처리한 노드, 최근에 스택에 들어온 노드
# 방문처리 - 스택에 한 번 삽인되어 처리된 노드가 다시 삽입되지 않게 체크하는 것을 의미.


# ex - DFS, 인접 리스트, 간선 없이 연결된 정보만
# DFS는 재귀함수 구현시 용이
def dfs(graph, v, visited): # 데이터, 시작노드, 방문노드
    # 현재 노드를 방문 처리
    visited[v] = True
    # print(v, end=' ')
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

# ex [2, 3, 8] - 노드1에 연결된 노드들
# 작은 수들 부터 적어놔야 차례대로 방문
graph = [
    [], # 노드0
    [2, 3, 8], # 노드1
    [1, 7], # 노드2
    [1, 4, 5], # 노드3
    [3, 5], # 노드4
    [3, 4], # 노드5
    [7], # 노드6
    [2, 6, 8], # 노드7
    [1, 7] # 노드8
]

# 각 노드가 방문한 정보를 리스트 자료형으로 표현(1차원 리스트)
# 방문 정보 초기화
visited = [False]*9

# 정의된 DFS 함수 호출
dfs(graph, 1, visited)




# 2. BFS(Breath-First Search)
# 너비 우선 탐색, 가까운 노드부터 탐색하는 알고리즘

# BFS의 응용
# 자료형식 : 큐(선입 선출)
# deque 라이브러리를 사용하는 것이 좋다
# 시간 복잡도 : O(N)
# 일반적으로 실제 수행 시간은 DFS보다 좋은 편이다.

# 동작 방식
# 1. 탐색 시작 노드를 큐에 삽입하고 방문처리를 한다.
# 2. 큐에서 노드를 꺼내 해당 노드와 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문처리를 한다.
# (넣는건 숫자가 작은 순으로, 노드를 꺼내는 건 밑에서 꺼냄(큐이기 때문))
# 3. 2의 과정을 더 이상 수행할 수 없을때까지 반복한다.

# ex 내가 만듦
from collections import deque

# def bfs(visited, quene, count):
#     visited[quene[0]] = True
#     for i in graph[quene[0]]:
#         if not visited[i]:
#             quene.append(i)
#             print(i, end=" ")
#             count += 1
#             visited[i] = True
    
            
#     quene.popleft()
#     if count == 8:
#         bfs(visited, quene, count)


# 내 코드와 다른 점
# 1. 재귀함수 사용 안함.
# 2. 큐에 데이터가 없을떄 까지 돌림
# 3. 큐에서 데이터 뺌과 동시에 변수로 저장해 사용
# 
def bfs(graph, start, visited):
    quene = deque([start])
    visited[start] = True
    while quene:
        v = quene.popleft()
        print(v, end= " ")
        for i in graph[v]:
            if not visited[i]:
                quene.append(i)
                visited[i] = True

    
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

# quene = deque() # append, popleft 사용
# quene.append(1)
# visited = [False] * 9
# count = 1
# print(1, end=" ")
# bfs(visited, quene, count)


visited = [False] * 9
bfs(graph, 1, visited)



# 정리
# 1. DFS
# 동작 원리 : 스택
# 구현 방법 : 재귀함수 이용
# 2. BFS
# 동작 원리 : 큐
# 구현 방법 : 큐 자료구조 이용(deque)

# (+)
# 탐색 문제를 만나면 그래프로 표현 후 다음 풀이법을 고민하자.