


# 떡볶이 만들기

# 그냥 작성
n = 4
require = 6
array = [19, 15, 10, 17]
for height in range(max(array), 0, -1):
    result = 0
    for i in array:
        if i >= height:
            result += (i - height)
    if result >= require:
        # print(height)
        break
# 문제점 : 데이터가 많아지면 끝도 없음


# 이진탐색 활용
# 
n = 4
require = 6
array = [19, 15, 10, 17]
start = 0
end = max(array)
final = 0
while end >= start:
    result = 0
    mid = (start+end)//2
    for i in array:
        if i > mid:
            result += (i-mid)
    if result >= require:
        final = mid
        start = mid + 1
    elif result < require:
        end = mid - 1
print(final)
