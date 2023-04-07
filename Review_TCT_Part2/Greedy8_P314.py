

# 만들 수 없는 금액

num = map(int, input("입력 : "))
num.sort()
target = 1
for i in num:
    if target < i:
        break
    target += i
print(target)
