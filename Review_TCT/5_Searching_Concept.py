

# 이진 탐색

# 구현 1. 재귀함수
def binary_search(array, start, end, find, count):
    if start > end:
        return None
    mid = (end+start)//2
    print("count : ", count)
    print(start, mid, end)
    if find > array[mid]:
        count += 1
        return binary_search(array, mid+1, end, find, count)
    elif find == array[mid]:
        return mid
    else:
        count += 1
        return binary_search(array, start, mid-1, find, count)


n = 10
find = 7
array = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
# print("result : ",  binary_search(array, 0, n-1, find, 1))


# 구현 2. 반복문 이용
n = 10
array = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
target = 10

start = 0
end = n-1
result = 0

while start <= end:
    mid = (start + end) // 2
    if target > array[mid]:
        start = mid + 1
    elif target < array[mid]:
        end = mid-1
    elif target == array[mid]:
        result = mid
        break

if result == 0:
    print('None')
else:
    print("Index : ", result)


# 빠르게 입력 받기
import sys
input_data = sys.stdin.readline().rstrip()
print(input_data[0])
