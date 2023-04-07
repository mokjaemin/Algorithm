


# 볼링공 고르기

n1 = 5
m = 3
balls1 = [1, 3, 2, 3, 2]
result1 = int(n1*(n1-1)/2)

n2 = 8
balls2 = [1, 5, 4, 3, 2, 3, 5, 2]
result2 = int(n2*(n2-1)/2)

array = [0]*n1
for i in balls1:
    array[i] += 1
# print(array)


n = 5
m = 3
balls = [1, 3, 2, 3, 2]
array = [0]*(m+1)
for i in balls:
    array[i] += 1
result = 0
for i in range(1, m+1):
    n -= array[i]
    print(n)
    result += array[i]*n
print(result)


def solution1(n, balls):
    count = 0
    for i in range(n):
        if i+1 <= n-1:
            if balls[i] in balls[i+1:]:
                count += 1
    return count

def solution2(n, balls):
    result = 0
    for i in range(n):
        for j in range(i+1, n):
            if balls[i] != balls[j]:
                result += 1
    return result


