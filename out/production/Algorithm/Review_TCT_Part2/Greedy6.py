


# 곱하기 혹은 더하기

num = input("입력 : ")
result = 0
for i in num:
    if result <= 1 or int(i) <= 1:
        result += int(i)
    else:
        result *= int(i)
print(result)