

# DFS 구현

# 인접행렬
graph1 = [
    [],
    [2, 3, 8], #1
    [1, 7], #2
    [1, 4, 5], #3 
    [3, 5], #4
    [3, 4], #5
    [7], #6
    [2, 6, 8], #7
    [1, 7], #8
]
# 인접리스트
graph2 = [[] for i in range(9)]
graph2[1].append([2, 3, 8])
graph2[2].append([1, 7])
graph2[3].append([1, 4, 5])
graph2[4].append([3, 5])
graph2[5].append([3, 4])
graph2[6].append([7])
graph2[7].append([2, 6, 8])
graph2[8].append([1, 7])


def dfs(graph1, start, visited):
    visited[start] = True
    print(start, end=" ")
    for i in graph1[start]:
        if not visited[i]:
            dfs(graph1, i, visited)

def bfs(queue, start, visited):
    queue.append(start)
    visited[start] = True
    while queue:
        now = queue.popleft()
        print(now, end=" ")
        for i in graph2[now][0]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
    


start = 1
visited = [False for i in range(9)]
visited[0] = True
from collections import deque
queue = deque()
# dfs(graph1, start, visited)
bfs(queue, start, visited)
