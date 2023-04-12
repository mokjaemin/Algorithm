



# 떡볶이 떡 만들기

n = 4
m = 7
arrays = [19, 15, 10, 17]

max_index = max(arrays)
min_index = 0
while max_index >= min_index:
    result = 0
    mid_index = (max_index+min_index)//2
    for array in arrays:
        if array - mid_index > 0:
            result += array-mid_index
    if result < m:
        max_index = mid_index-1
    else:
        min_index = mid_index+1
print(mid_index)



