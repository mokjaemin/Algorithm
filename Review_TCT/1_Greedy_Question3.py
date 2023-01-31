

# 3. 문자열 뒤집기
num = str(input("입력 : "))
count0 = 0
count1 = 0
if num[1] == 1:
    count1 = 1
else:
    count0 = 1
for i in range(1, len(num)):
    if num[i] == 0:
        count0 += 1
    elif num[1] == 1:
        count1 += 1
    