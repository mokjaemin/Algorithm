
# 문자열 뒤집기

input = input("입력 : ")
result = []
index0 = 0
index1 = 0
for i in range(len(input)):
    if i == 0:
        result.append(input[i])
        continue
    if result[-1] == input[i]:
        result.append(input[i])
    else:
        if int(result[-1]) == 0:
            index0 += 1
            result = [input[i]]
        else:
            index1 += 1   
            result = [input[i]]
if result[0] == 0:
    index0 += 1
else:
    index1 += 1
print(index0)
print(index1)