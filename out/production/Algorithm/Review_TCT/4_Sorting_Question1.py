

# 위에서 아래로

n = int(input("입력 : "))
array = []
for i in range(n):
    array.append(int(input("입력 : ")))
print(sorted(array, reverse=True))