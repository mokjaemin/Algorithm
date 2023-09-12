


# 볼링공 고르기


n = 5
m = 3
balls = [1, 3, 2, 3, 2]
array = [0]*(m+1)
for i in balls:
    array[i] += 1
result = 0
for i in range(1, m+1):
    n -= array[i]
    result += array[i]*n
    # print(result)






n = 8
m = 5
array = [1, 5, 4, 3, 2, 4, 5, 2]
check = [0]*(m+1)
for i in array:
    check[i] += 1
print(check)

result = 0
for i in range(1, m+1):
    n -= check[i]
    result += check[i]*n
print(result)




