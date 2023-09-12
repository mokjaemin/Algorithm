


# 카드 정렬하기

# 나의 방법 1
from itertools import permutations
n = 8
cardList = [10, 40, 20, 50, 60, 80, 150, 90]
checkList = list(permutations(cardList, len(cardList)))
final = []
for i in checkList:
    result = 0
    for j in range(1, n):
        for k in range(j+1):
            result += i[k]
    final.append(result)
print(min(final))


# 나의 방법 2
# 어쩌피 작은 수부터 더해야만 가능하다 라는 생각
n = 8
cardList = [10, 40, 20, 50, 60, 80, 150, 90]
cardList.sort()
result = 0
for j in range(1, n):
    for k in range(j+1):
        result += cardList[k]
print(result)