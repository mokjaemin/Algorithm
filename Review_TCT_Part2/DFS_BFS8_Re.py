



# 감시 피하기


graph = []
x_pos = []
t_pos = []
s_pos = []

n = int(input())
for i in range(n):
    graph.append(list(input().split()))
    for j in range(n):
        if graph[i][j] == 'X':
            x_pos.append([i, j])
        if graph[i][j] == 'T':
            t_pos.append([i, j])
        if graph[i][j] == 'S':
            s_pos.append([i, j])


from itertools import combinations
o_pos = list(combinations(x_pos, 3))



def find_by_direction(x, y, direction):
    if direction == 0: # 북
        if x-1 < 0 or graph[x-1][y] == 'O':
            return False
        if graph[x-1][y] == 'S':
            return True
        if graph[x-1][y] == 'T' or graph[x-1][y] == 'X':
            return find_by_direction(x-1, y, direction)
    elif direction == 1: # 서
        if y-1 < 0 or graph[x][y-1] == 'O':
            return False
        if graph[x][y-1] == 'S':
            return True
        if graph[x][y-1] == 'T' or graph[x][y-1] == 'X':
            return find_by_direction(x, y-1, direction)
    elif direction == 2: # 남
        if x+1 >= n or graph[x+1][y] == 'O':
            return False
        if graph[x+1][y] == 'S':
            return True
        if graph[x+1][y] == 'T' or graph[x+1][y] == 'X':
            return find_by_direction(x+1, y, direction)
    else: # 동 
        if y+1 >= n or graph[x][y+1] == 'O':
            return False
        if graph[x][y+1] == 'S':
            return True
        if graph[x][y+1] == 'T' or graph[x][y+1] == 'X':
            return find_by_direction(x, y+1, direction)


dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
def find_student(x, y):
    for i in range(4):
        next_x = x + dx[i]
        next_y = y + dy[i]
        if next_x < 0 or next_x >= n or next_y < 0 or next_y >= n:
            continue
        if graph[next_x][next_y] == 'O':
            continue
        if graph[next_x][next_y] == 'S':
            return True
        direction = i
        if graph[next_x][next_y] == 'T' or graph[next_x][next_y] == 'X':
            if find_by_direction(next_x, next_y, direction):
                return True
    return False



for obstacles in o_pos:
    for obstacle in obstacles:
        graph[obstacle[0]][obstacle[1]] = 'O'

    continue_check = True
    for t in t_pos:
        if find_student(t[0], t[1]):
            continue_check = False
            break
    
    if continue_check:
        for i in graph:
            print(i)
        break
    
    for obstacle in obstacles:
        graph[obstacle[0]][obstacle[1]] = 'X'