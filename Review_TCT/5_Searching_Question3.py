

# 정렬된 배열에서 특정 수의 개수 구하기

# 내가 구현
def binary_search(array, start, end, target):
    count = 0
    if start > end:
        return 0
    mid = (start + end)//2
    if array[mid] > target:
        count += binary_search(array, start, mid-1, target)
    elif array[mid] < target:
        count += binary_search(array, mid+1, end, target)
    elif array[mid] == target:
        count += 1
        count += binary_search(array, start, mid-1, target)
        count += binary_search(array, mid+1, end, target)
    return count

target = 4
array = [1, 1, 2, 2, 2, 2, 2, 2, 2, 3]
count = binary_search(array, 0, len(array)-1, target)
# if count:
#     print(count)
# else:
#     print("-1")




# 답변 1
def count_by_value(array, x):
    n = len(array)
    a = first(array, x, 0, n-1)
    # print("first : ", a)
    if a == None:
        return 0
    b = last(array, x, 0, n-1)
    # print("last: ", b)
    return b - a + 1

def first(array, target, start, end):
    if start > end:
        return None
    mid = (start+end)//2
    if (mid == 0 or target > array[mid-1]) and array[mid] == target:
        return mid
    elif array[mid] >= target:
        return first(array, target, start, mid-1)
    else: # array[mid] < target
        return first(array, target, mid+1, end)
    
def last(array, target, start, end):
    if start > end:
        return None
    mid = (start+end)//2
    if (mid == n-1 or target < array[mid+1]) and array[mid] == target:
        return mid
    elif array[mid] > target:
        return last(array, target, start, mid-1)
    else:
        return last(array, target, mid+1, end)


n = 7
x = 2
array = [1, 1, 2, 2, 2, 2, 3]
result = count_by_value(array, x)
# print(result)




# 답변 2
from bisect import bisect_left, bisect_right

def count_by_range(array, left_value, right_value):
    right_index = bisect_right(array, right_value)
    left_index = bisect_left(array, left_value)
    return right_index - left_index

x = 2
array = [1, 1, 2, 2, 2, 2, 3]
count = count_by_range(array, x, x)
print(count)