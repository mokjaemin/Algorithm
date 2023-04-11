

# 개미 전사

n = 8
food = [1, 3, 1, 5, 1, 1, 8, 10]
check = [0]*(n+1)
check[1] = food[0]
check[2] = max(check[1], food[1])

for i in range(3, n+1):
    check[i] = max(check[i-1], check[i-2]+food[i-1])
print(check)
print(check[-1])
