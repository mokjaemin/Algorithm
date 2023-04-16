



# 화성 탐사
import heapq
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
final_result = []
INF = int(1e9)

t = int(input())
for time in range(t):
    n = int(input())
    graph = []
    for i in range(n):
        graph.append(list(map(int, input().split())))
    
    distance = [[INF]*n for _ in range(n)]
    distance[0][0] = graph[0][0]
    q = []
    heapq.heappush(q, [graph[0][0], 0, 0])
    while q:
        cost, x, y = heapq.heappop(q)
        for move in range(4):
            next_x = x + dx[move]
            next_y = y + dy[move]
            if next_x < 0 or next_x >= n or next_y < 0 or next_y >= n:
                continue
            new_cost = graph[next_x][next_y] + cost
            if distance[next_x][next_y] > new_cost:
                distance[next_x][next_y] = new_cost
                heapq.heappush(q, [new_cost, next_x, next_y])
        
    print(" ")
    for i in distance:
        print(i)
    print(" ")

