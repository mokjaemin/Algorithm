


# n = 5
# graph = [
#     ['X', 'S', 'X', 'X', 'T'],
#     ['T', 'X', 'S', 'X', 'X'],
#     ['X', 'X', 'X', 'X', 'X'],
#     ['X', 'T', 'X', 'X', 'X'],
#     ['X', 'X', 'T', 'X', 'X'],
# ]
# n = 4
# graph = [
#     ['S', 'S', 'S', 'T'],
#     ['X', 'X', 'X', 'X'],
#     ['X', 'X', 'X', 'X'],
#     ['T', 'T', 'T', 'X']
# ]

n = int(input())
graph = []
for i in range(n):
    graph.append(list(input().split()))


# 선생과 빈공간 위치
teachers = []
space = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'T':
            teachers.append([i, j])
        if graph[i][j] == 'X':
            space.append([i, j])



# 발견시 False
def watch(x, y, direction):
    if direction == 0:
        if x-1 >= 0:
            if graph[x-1][y] == 'S':
                return False
            elif graph[x-1][y] == 'X':
                return watch(x-1, y, direction)
    elif direction == 1:
        if y-1 >= 0:
            if graph[x][y-1] == 'S':
                return False
            elif graph[x][y-1] == 'X':
                return watch(x, y-1, direction)
    elif direction == 2:
        if x+1 < n:
            if graph[x+1][y] == 'S':
                return False
            elif graph[x+1][y] == 'X':
                return watch(x+1, y, direction)
    else:
        if y+1 < n:
            if graph[x][y+1] == 'S':
                return False
            elif graph[x][y+1] == 'X':
                return watch(x, y+1, direction)
    return True


# 북, 서, 남, 동
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


# 감시 피하기 성공시 True
def process(teacher):
    x = teacher[0]
    y = teacher[1]
    for direction in range(4):
        next_x = x + dx[direction]
        next_y = y + dy[direction]
        if next_x < 0 or next_x >= n or next_y < 0 or next_y >= n:
            continue
        if graph[next_x][next_y] == 'O':
            continue
        result = watch(next_x, next_y, direction)
        if not result:
            return False
    return True


from itertools import combinations
for obstacles in list(combinations(space, 3)):
    # 장애물 설치
    for obstacle in obstacles:
        graph[obstacle[0]][obstacle[1]] = 'O'
    
    # 선생 위치마다 감시 시작
    count = 0
    for teacher in teachers:
        result = process(teacher)
        if result:
            count += 1
    
    if count == len(teachers):
        # for i in graph:
        #     print(i)
        print("YES")
        break

    
    # 장애물 해제
    for obstacle in obstacles:
        graph[obstacle[0]][obstacle[1]] = 'X'


if count != len(teachers):
    print("NO")