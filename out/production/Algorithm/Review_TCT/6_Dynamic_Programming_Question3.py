



# 바닥 공사

n = 5
check = [0]*100
d = [0]*100
check[1] = 1
check[2] = 3
d[1] = 1
d[2] = 3
for i in range(3, n+1):
    check[i] = 1 + (check[i-1]-1)*2
    d[i] = d[i-1] + 2 * d[i-2]
print(check[n])
print(d[n])
