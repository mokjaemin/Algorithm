



# 인구 이동

n, min_value, max_value = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))


from collections import deque


dx = [-1, 0, 1, 0]
dy = [0, -1 ,0, 1]
real_count = 0


while(1):

    again_check = False
    check = [[0]*n for _ in range(n)]
    q = deque()

    group = 0
    sum_list = []
    count_list = []

    for x in range(n):
        for y in range(n):
            if check[x][y] != 0:
                continue
            q.append([x, y])
            group += 1
            check[x][y] = group
            sum_result = graph[x][y]
            count_result = 1
            while q:
                now_x, now_y = q.popleft()
                for i in range(4):
                    next_x = now_x + dx[i]
                    next_y = now_y + dy[i]
                    if next_x < 0 or next_x >= n or next_y < 0 or next_y >= n:
                        continue
                    if check[next_x][next_y] != 0:
                        continue
                    if min_value <= abs(graph[next_x][next_y]-graph[now_x][now_y]) <= max_value:
                        check[next_x][next_y] = group
                        q.append([next_x, next_y])
                        again_check = True
                        sum_result += graph[next_x][next_y]
                        count_result += 1
            sum_list.append(sum_result)
            count_list.append(count_result)
    

    if again_check == False:
        break


    for change in range(1, group+1):
        for x in range(n):
            for y in range(n):
                if check[x][y] == change:
                    graph[x][y] = int(sum_list[change-1]/count_list[change-1])
    
    real_count += 1

print(real_count)

    





