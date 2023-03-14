


# 정수 삼각형

n = 5
triangle = [
    [7],
    [3, 8],
    [8, 1, 0],
    [2, 7, 4, 4],
    [4, 5, 2, 6, 5]
]
for i in range(len(triangle[1])):
    triangle[1][i] += triangle[0][0]

for i in range(2, len(triangle)):
    for j in range(len(triangle[i])):
        result = []
        if j == 0:
            triangle[i][j] += triangle[i-1][j]
        elif j == len(triangle[i])-1:
            triangle[i][j] += triangle[i-1][j-1]
        else:
            triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
    for k in triangle:
        print(k)

print(max(triangle[n-1]))