



# 금광

arrays = [
    [1, 3, 1, 5],
    [2, 2, 4, 1],
    [5, 0, 2, 3],
    [0, 6, 2, 1]
]
check = arrays
d = [-1, 0, 1]

for j in range(1, len(arrays[0])): # 4
    for i in range(len(arrays)): # 3
        now = 0
        for k in d:
            if 0 <= i+k < len(arrays):
                now = max(now, check[i+k][j-1])
        check[i][j] = check[i][j] + now
        for i in check:
            print(i)
        print(" ")

result = 0
for i in range(len(arrays)):
    result = max(result, arrays[i][len(arrays[0])-1])
print(result)