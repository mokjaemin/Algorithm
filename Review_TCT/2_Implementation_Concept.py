

# 예제 1) 상하 좌우
# n = int(input("입력 : "))
# direction = list(map(str, input("입력 : ").split()))
# print(direction)
# dx = [-1, 0, 1, 0] # 북, 서, 남, 동
# dy = [0, -1, 0, 1]
# start = [1, 1]
# for i in range(len(direction)):
#     if direction[i] == 'U':
#         if start[0] > 1:
#             start[0] += dx[0]
#             start[1] += dy[0]
#     elif direction[i] == 'L':
#         if start[1] > 1:
#             start[0] += dx[1]
#             start[1] += dy[1]
#     elif direction[i] == 'D':
#         if start[0] < n:
#             start[0] += dx[2]
#             start[1] += dy[2]
#     else:
#         if start[1] < n:
#             start[0] += dx[3]
#             start[1] += dy[3]
# print(start)


# 예제 2) 시각
# n = int(input("입력 : "))
# count = 0
# check = [3, 13, 23, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 43, 53]
# for i in range(n+1): # 시
#     if i in check:
#         count += 3600
#     else:
#         for j in range(60):
#             if j in check:
#                 count += 60
#             else:
#                 for k in range(60):
#                     if k in check:
#                         count += 1
# print(count)



# 실전문제 1) 왕실의 나이트
# pos = input("입력 : ")
# x = int(ord(pos[0]) - int(ord('a'))) + 1
# y = int(pos[1])
# dx = [2, 2, -2, -2, 1, -1, 1, -1]
# dy = [1, -1, 1, -1, 2, 2, -2, -2]
# count = 0
# for i in range(8):
#     if 1 <= x + dx[i] <= 8 and 1 <= x + dy[i] <= 8:
#         count += 1
# print(count)


# 실전문제 2) 게임 개발
# dir : 0(북), 1(동), 2(남), 3(서)
# 순서 : 0, 3, 2, 1
n, m = map(int, input("입력 : ").split())
x, y, dir = map(int, input("입력 : ").split())
arr = []
for i in range(n):
    arr.append(list(map(int, input("입력 : ").split())))
def check(x, y):
    global dir
    global count
    global result    
    if dir == 0:
        if arr[x][y-1] == 0:
            arr[x][y-1] = 2
            y = y-1
            result += 1
            count = 0
        else:
            dir = 3
            count += 1
    elif dir == 3:
        if arr[x+1][y] == 0:
            arr[x+1][y] = 2
            x = x+1
            result += 1
            count = 0
        else:
            dir = 2
            count += 1
    elif dir == 2:
        if arr[x][y+1] == 0:
            arr[x][y+1] = 2
            y = y+1
            result += 1
            count = 0
        else:
            dir = 1
            count += 1
    else:
        if arr[x-1][y] == 0:
            arr[x-1][y] = 2
            x = x-1
            result += 1
            count = 0
        else:
            dir = 0
            count += 1
    return x, y
count = 0
result = 1
arr[x][y] = 2
while(1):
    x, y = check(x, y)
    if count == 4:
        break
print(result)