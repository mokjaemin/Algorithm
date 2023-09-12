

# 효율적인 화폐구성


n = 3
result = 10
coins = [2, 3, 5]
INF = 1e9
check = [INF]*(result+1)

for coin in coins:
    check[coin] = 1

for i in range(1, result+1):
    for coin in coins:
        if i % coin == 0:
            check[i] = min(check[i], i//coin)
        if check[i-coin] != INF:
            check[i] = min(check[i], check[i-coin]+1)
    
print(check)