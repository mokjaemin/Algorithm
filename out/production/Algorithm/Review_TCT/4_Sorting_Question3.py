


# 두 배열의 원소 교체
a = [1, 2, 5, 4, 3]
b = [5, 5, 6, 6, 5]
k = 3
n = 5
a.sort()
b.sort(reverse=True)
for i in range(k):
    if a[i] < b[i]:
        a[i], b[i] = b[i], a[i]
    else:
        break
result = 0
for j in a:
    result += j
print(result)