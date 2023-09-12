

# 2. 곱하기 혹은 더하기

num = str(input("입력 : "))
result = 0
for i in num:
    if int(i) == 0 or int(i) == 1 or result == 0:
        result += int(i)
    else:
        result *= int(i)
print(result)