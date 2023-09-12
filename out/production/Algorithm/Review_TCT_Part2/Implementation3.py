


# 왕실의 나이트

pos = "a1"
column = int( ord(pos[0]) - int(ord('a')) ) + 1
row = int(pos[1])
a = [-2, 2]
b = [-1, 1]

count = 0

for i in range(2):
    for j in range(2):
        x_pos = column + a[i]
        y_pos = row + b[j]
        if 1 <= x_pos <= 8 and 1 <= y_pos <= 8:
            count += 1

for i in range(2):
    for j in range(2):
        x_pos = column + b[i]
        y_pos = row + a[j]
        if 1 <= x_pos <= 8 and 1 <= y_pos <= 8:
            count += 1
# print(count)


count = 0
steps = [[-2, -1], [-2, 1], [2, -1], [2, 1], [1, 2], [1, -2], [-1, 2], [-1, -2]]

for step in steps:
    x_pos = column + step[0]
    y_pos = row + step[1]
    if 1 <= x_pos <= 8 and 1 <= y_pos <= 8:
            count += 1
print(count)

