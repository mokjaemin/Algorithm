


# 1. 모험가 길드
n = int(input("입력 : "))
array = list(map(int, input("입력 : ").split()))
array.sort()
count = [0]*100001
result = 0
spare = 0
for i in array:
    count[i] += 1
for i in range(1, array[-1]+1):
    if i > count[i] + spare:
        continue
    elif i < count[i] + spare:
        result += count[i]//i
        spare += count[i]%i
    else:
        result += 1
print(result)
    

# 답안
n = int(input())
data = list(map(int, input().split()))
data.sort()

result = 0
count = 0

for i in data:
    count += 1
    if count >= i:
        result += 1
        count = 0
print(result)