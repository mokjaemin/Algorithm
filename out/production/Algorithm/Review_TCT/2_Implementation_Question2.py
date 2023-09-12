

# 문자열 재정렬

n = list(input("입력 : "))
n = sorted(n)
index = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
result = 0
strindex = []
for i in range(len(n)):
    if n[i] in index:
        result += int(n[i])
    else:
        strindex.append(n[i])
        
for i in strindex:
    print(i, end="")
print(result, end="")
print("")