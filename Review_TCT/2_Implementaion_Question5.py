

# 뱀

from collections import deque

n = int(input("입력 : "))
num_apple = int(input("입력 : "))
pos_apple = []
for i in range(num_apple):
    pos_apple.append(list(map(int, input("입력 : ").split())))
snake_direction = int(input("입력 : "))
snake_change = []
for i in range(snake_direction):
    snake_change.append(list(input("입력 : ").split()))
    snake_change[i][0] = int(snake_change[i][0])

def snake_move(next):
    apple_exist = 0
    snake_pos.append(next)
    for i in pos_apple:
        if i == next:
            apple_exist = 1
            break
    if apple_exist == 0:
        del snake_pos[0]


dx = [0, 0, -1, 1] # 오, 왼, 상, 하
dy = [1, -1, 0, 0]
time = 0
dir = 0 # 오른쪽
snake_pos = [[0, 0]]
while(1):
    # 벽체크
    if snake_pos[-1][0] >= n or snake_pos[-1][0] < 0:
        print("벽통과")
        print("종료시간 : ", time)
        break
    if snake_pos[-1][1] >= n or snake_pos[-1][1] < 0:
        print("벽통과")
        print("종료시간 : ", time)
        break
    # 자기 몸 체크
    for i in snake_pos[0:-1]:
        if i == snake_pos[-1]:
            print("자기 몸")
            print("종료시간 : ", time)
            break

    if dir == 0: # 오른쪽
        snake_move([snake_pos[-1][0] + dx[0], snake_pos[-1][1] + dy[0]])
    elif dir == 180: # 왼쪽
        snake_move([snake_pos[-1][0] + dx[1], snake_pos[-1][1] + dy[1]])
    elif dir == 270: # 위쪽
        snake_move([snake_pos[-1][0] + dx[2], snake_pos[-1][1] + dy[2]])
    else: # 아래쪽 
        snake_move([snake_pos[-1][0] + dx[3], snake_pos[-1][1] + dy[3]])
    time += 1

    for change in snake_change:
        if time == change[0]:
            if change[1] == 'D':
                dir += 90
            else:
                dir -= 90
    if dir == 360:
        dir = 0
    if dir == -90:
        dir = 270
    
    print("방향 : ", dir)
    print("시간 : ", time)
    print("뱀의 위치 : ", snake_pos)
    