


# 개미 전사


n = 7
array = [0, 1, 3, 1, 5, 6, 2, 7]
check = [0]*(n+1)
check[1] = array[1]
check[2] = max(check[1], array[2])

for i in range(3, n+1):
    check[i] = max(check[i-2] + array[i], check[i-1])

print(check)