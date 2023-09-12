

# 큰 수의 법칙

n, m, k = 5, 8, 3
num = [2, 4, 5, 4, 6]
num.sort(reverse=True)
print(num[0]*(m//k)*k + num[1]*(m%k))