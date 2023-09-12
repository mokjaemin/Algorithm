


# 부품 찾기
n = 5
products = [8, 3, 7, 9, 2]
m = 3
targets = [5, 7, 9]


# 방법 1
for target in targets:
    if target not in products:
        print("no", end=" ")
    else:
        print("yes", end=" ")
print(" ")


# 방법 2 - 이진탐색
products.sort()
for target in targets:
    start = 0
    end = n-1
    result = 'no'
    while end >= start:
        mid = (start + end)//2
        if products[mid] == target:
            result = "yes"
            break
        elif products[mid] > target:
            end = mid -1
        elif products[mid] < target:
            start = mid + 1
    print(result, end=" ")
print("")


# 방법 3. 계수 정렬
products = [8, 3, 7, 9, 2]
checkList = [0]*10
for product in products:
    checkList[product-1] += 1
for target in targets:
    if checkList[target-1] >= 1:
        print("yes", end=" ")
    else:
        print("no", end=" ")
print(" ")