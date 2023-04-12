



# 정렬된 배열에서 특정 수의 개수 구하기

from bisect import bisect_left, bisect_right

n = 7
x = 2
array = [1, 1, 2, 2, 2, 2, 3]

left_index = bisect_left(array, 0)
right_index = bisect_right(array, x)
print(left_index, right_index)
result = right_index-left_index

if result == 0:
    print("-1")
else:
    print(result)


