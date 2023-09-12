


# 1로 만들기

n = 26

check = [0]*(n+1)
check[1] = 0

for i in range(2, n+1):

    check[i] = check[i-1] + 1

    if i % 5 == 0:
        check[i] = min(check[i], check[int(i/5)] + 1)

    if i % 3 == 0:
        check[i] = min(check[i], check[int(i/3)] + 1)

    if i % 2 == 0:
        check[i] = min(check[i], check[int(i/2)] + 1)

    print(i, check[i])



print(check[n])