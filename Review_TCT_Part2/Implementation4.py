


# 게임 개발


# 0(북), 1(동), 2(남), 3(서) : 시계방향
# 순서 : 0 - 3 - 2 - 1 : 반시계

array = [
    [1, 1, 1, 1, 1],
    [1, 0, 0, 0, 1],
    [1, 1, 0, 1, 1],
    [1, 1, 1, 1, 1],
    [1, 1, 1, 1, 1]
]
start_dir = 0
start_x = 1
start_y = 1
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
count = 0
result = 1

while(1):
    array[start_x][start_y] = 1
    left = start_dir-1
    if left < 0:
        left = 3
    pos_x = start_x + dx[left] 
    pos_y = start_y + dy[left]
    if 0 <= pos_x <= len(array) and 0 <= pos_y <= len(array):
        if array[pos_x][pos_y] == 0:
            array[pos_x][pos_y] = 1
            start_x = pos_x
            start_y = pos_y
            count = 0
            result += 1
    start_dir -= 1
    if start_dir < 0:
        start_dir = 3
    count += 1
    for i in array:
        print(i)
    print(" ")
    if count >= 4:
        break

print(result)


