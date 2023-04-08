

# 상하좌우

n = 5
start = [1, 1]
direction = ['R', 'R', 'R', 'U', 'D', 'D']
# U(0), L(1), D(2), R(3)
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
dtype = ['U', 'L', 'D', 'R']


for i in direction:
    for j in range(4):
        if i == dtype[j]:
            x_pos = start[0] + dx[j]
            y_pos = start[1] + dy[j]
    if 1 <= x_pos <= n and 1 <= y_pos <= n:
        start[0] = x_pos
        start[1] = y_pos
    print(start)
print(start)


# for i in direction:
#     if i == 'U':
#         if start[0] + dx[0] >= 1:
#             start[0] += dx[0]
#             start[1] += dy[0]
#     elif i == 'L':
#         if start[1] + dy[1] >= 1:
#             start[0] += dx[1]
#             start[1] += dy[1]
#     elif i == 'D':
#         if start[0] + dx[2] <= n:
#             start[0] += dx[2]
#             start[1] += dy[2]
#     else:
#         if start[1] + dy[3] <= n:
#             start[0] += dx[3]
#             start[1] += dy[3]
# print(start[0], start[1])