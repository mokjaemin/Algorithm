

# 예제 1) 상하 좌우
n = int(input("입력 : "))
direction = list(map(str, input("입력 : ").split()))
print(direction)
dx = [-1, 0, 1, 0] # 북, 서, 남, 동
dy = [0, -1, 0, 1]
start = [1, 1]
for i in range(len(direction)):
    if direction[i] == 'U':
        if start[0] > 1:
            start[0] += dx[0]
            start[1] += dy[0]
    elif direction[i] == 'L':
        if start[1] > 1:
            start[0] += dx[1]
            start[1] += dy[1]
    elif direction[i] == 'D':
        if start[0] < n:
            start[0] += dx[2]
            start[1] += dy[2]
    else:
        if start[1] < n:
            start[0] += dx[3]
            start[1] += dy[3]
print(start)


# 예제 2) 시각
