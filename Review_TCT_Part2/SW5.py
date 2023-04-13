





# 화성 탐사

import heapq

t = 3
n = 7
graph = [
    [9, 0, 5, 1, 1, 5, 3],
    [4, 1, 2, 1, 6, 5, 3],
    [0, 7, 6, 1, 6, 8, 5],
    [1, 1, 7, 8, 3, 2, 3],
    [9, 4, 0, 7, 6, 4, 1],
    [5, 8, 3, 2, 4, 8, 3],
    [7, 4, 8, 4, 8, 3, 4]
]

INF = int(1e9)
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

start = [0, 0]
cost = graph[start[0]][start[1]]
q = []
heapq.heappush(q, [cost, start])
distance = [[INF]*n for _ in range(n)]
distance[start[0]][start[1]] = cost

while q:
    now_cost, now_pos = heapq.heappop(q)
    # 현재 노드가 굳이 처리할 필요가 없는 노드라면 패스
    if now_cost > distance[now_pos[0]][now_pos[1]]:
        print("a ")
        continue
    for i in range(4):
        next_x = now_pos[0] + dx[i]
        next_y = now_pos[1] + dy[i]
        if next_x < 0 or next_x >= n or next_y < 0 or next_y >= n:
            continue
        next_cost = now_cost + graph[next_x][next_y]
        if distance[next_x][next_y] > next_cost:
            distance[next_x][next_y] = next_cost
            heapq.heappush(q, [next_cost, [next_x, next_y]])

for i in distance:
    print(i)
