


# 1로 만들기

n = int(input())
INF = 1e9
check = [INF]*(n+1)
check[1] = 0
check[2] = 1
for i in range(3, n+1):
    if i % 2 == 0:
        check[i] = min(check[i], check[i//2]+1)
    if i % 3 == 0:
        check[i] = min(check[i], check[i//3]+1)
    if i % 5 == 0:
        check[i] = min(check[i], check[i//5]+1)
    check[i] = min(check[i], check[i-1]+1)
print(check[n])
