


# 뱀

def solution(n, apples, turn):
    turn_index = 0
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    direction = 0
    snake_pos = [[0, 0]]
    time = 0
    for i in range(30):
        time += 1
        next_x = snake_pos[-1][0] + dx[direction]
        next_y = snake_pos[-1][1] + dy[direction]

        # 사과 체크
        if [next_x, next_y] in apples:
            snake_pos.append([next_x, next_y])
        else:
            snake_pos.append([next_x, next_y])
            snake_pos.pop(0)
        
        # 방향 변경 체크
        if turn_index < len(turn):
            if time == turn[turn_index][0]:
                # 자신의 몸과 충돌
                if len(snake_pos) > 1:
                    return time
                if turn[turn_index][1] == 'D':
                    direction += 1
                else:
                    direction -= 1
                turn_index += 1
        if direction < 0:
            direction = 3
        if direction > 3:
            direction = 1

        # 벽 충돌 체크
        if snake_pos[-1][0] < 0 or snake_pos[-1][0] > n-1:
            return time
        if snake_pos[-1][1] < 0 or snake_pos[-1][1] > n-1:
            return time
        

        print("times : ", time, "pos : ", snake_pos)





n1 = 6
n2 = 10

apples = [
    [3, 4],
    [2, 5],
    [5, 3]
]

apples1 = [
    [1, 2],
    [1, 3],
    [1, 4],
    [1, 5]
]

apples2 = [
    [1, 5],
    [1, 3],
    [1, 2],
    [1, 6],
    [1, 7]
]

turn = [
    [3, 'D'],
    [15, 'L'],
    [17, 'D']
]

turn1 = [
    [8, 'D'],
    [10, 'D'],
    [11, 'D'],
    [13, 'L']
]

print(solution(n1, apples, turn))