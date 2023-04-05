

# 만들 수 없는 금액

num = [3, 2, 1, 1, 9]
num.sort()
target = 1
for i in num:
    if target < i:
        break
    target += i
print(target)

