

# 바닥공사


n = 10000
check = [0]*(n+1)
check[1] = 1
check[2] = 3

for i in range(3, n+1):
    check[i] = check[i-1] + 2*check[i-2]
print(check[n]%796796)

