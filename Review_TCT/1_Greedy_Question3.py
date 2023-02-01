

# 3. 문자열 뒤집기
num = list(input("입력 : "))
if num[0] == '1':
    change0 = 0
    change1 = 1
else:
    change0 = 1
    change1 = 0
for i in range(len(num)-1):
    if num[i] != num[i+1]:
        if num[i+1] == '1':
            change0 += 1
        else:
            change1 += 1
print(change0)
print(change1)