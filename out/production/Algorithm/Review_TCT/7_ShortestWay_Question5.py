

# 화성탐사

import heapq
def main(graph, n):
    INF = int(1e9)
    distance = [[INF]*n for _ in range(n)]
    q = []
    start = 0
    end = n-1
    distance[start][start] = graph[start][start]
    heapq.heappush(q, (graph[start][start], (start, start)))
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    while q:
        dist, now = heapq.heappop(q)
        print(now, "와 start 노드 사이의 거리", dist)
        if dist > distance[now[0]][now[1]]:
            continue
        for i in range(4):
            x = now[0] + dx[i]
            y = now[1] + dy[i]
            if 0 <= x <= n-1 and 0 <= y <= n-1:
                if dist + graph[x][y] < distance[x][y]:
                    distance[x][y] = graph[x][y] + dist
                    heapq.heappush(q, (graph[x][y] + dist, (x, y)))
        
        print("heapq : ", q)
        print("그래프 변화")
        for i in distance:
            print(i)
        print(" ")
        

    



n1 = 3
graph1 = [
    [5, 5, 4],
    [3, 9, 1],
    [3, 2, 7],
]
n2 =5
graph2 = [
    [3, 7, 2, 0, 1],
    [2, 8, 0, 9, 1],
    [1, 2, 1, 8, 1],
    [9, 8, 9, 2, 0],
    [3, 6, 5, 1, 5]
]
n3 = 7
graph3 = [
    [9, 0, 5, 1, 1, 5, 3],
    [4, 1, 2, 1, 6, 5, 3],
    [0, 7, 6, 1, 6, 8, 5],
    [1, 1, 7, 8, 3, 2, 3],
    [9, 4, 0, 7, 6, 4, 1],
    [5, 8, 3, 2, 4, 8, 3],
    [7, 4, 8, 4, 8, 3, 4]
]

main(graph1, n1)