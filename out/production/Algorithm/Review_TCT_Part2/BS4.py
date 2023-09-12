


# 고정점 찾기

arrays = [-15, -6, 1, 3, 7]
# arrays = [-15, -4, 2, 8, 9, 13, 15]
# arrays = [-15, -4, 3, 8, 9, 13, 15]


start = 0
end = len(arrays)

while start <= end:
    mid = (start + end) // 2
    if arrays[mid] == mid:
        print(mid)
        break
    elif arrays[mid] > mid:
        end = mid - 1
    else:
        start = mid + 1
if start > end:
    print("-1")








from bisect import bisect_left
result = False
for array in arrays:
    index = bisect_left(arrays, array)
    if index == array:
        result = True
        break
if result:
    print(index)
else:
    print("-1")