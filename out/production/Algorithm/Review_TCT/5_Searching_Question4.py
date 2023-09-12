



# 고정점 찾기

# 양수 부분 찾기
def find_plus(array, start, end):
    n = len(array)
    while start <= end:
        mid = (start+end)//2
        if array[mid] == 0:
            return mid
        elif array[mid] > 0:
            if array[mid-1] < 0:
                return mid
            else:
                end = mid - 1
        elif array[mid] < 0:
            start = mid + 1

# n = 5
# array = [-15, -6, 1, 3, 7]
n = 7
array = [-15, -4, 2, 8, 9, 13, 15]
# n = 7
# array = [-15, -4, 3, 8, 9, 13, 15]


print(array)
start = find_plus(array, 0, n-1)
result = []
while start <= n-1:
    if array[start] == start:
        result.append(start)
        start += 1
    elif array[start] < start:
        start += 1
    elif array[start] > start:
        if start <= n-1:
            start = array[start]
        else:
            break
# if not result:
#     print("-1")
# else:
#     print(result)



# 답변
def binary_search(array, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if array[mid] == mid:
        return mid
    elif array[mid] > mid:
        return binary_search(array, start, mid-1)
    else:
        return binary_search(array, mid+1, end)
n = 7
array = [-15, -4, 2, 8, 9, 13, 15]
print(binary_search(array, 0, len(array)-1))