

# 문자열 재정렬

input = "K1KA5CB7"
input = "AJKDLSI412K4JSJ9D"

str_list = []
num = 0
for i in range(len(input)):
    if input[i].isalpha():
        str_list.append(input[i])
        continue
    num += int(input[i])

str_list.sort()
result = []
for i in range(len(str_list)):
    result.append(str_list[i])
if num != 0:
    result.append(str(num))
print("".join(result))