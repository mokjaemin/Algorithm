


# 병사 배치하기
# 답안
array = [15, 11, 13, 12, 9, 8, 6, 7, 2]
array.reverse()
n = len(array)
print(array)
dp = [1]*n
for i in range(1, n):
    print(array[i], "에 대해서")
    for j in range(0, i):
        if array[j] < array[i]: # 작은게 나오면
            print(array[j], end=" ")
            dp[i] = max(dp[i], dp[j]+1)
    print(" ")
print(" ")
print(dp)
print(n-max(dp))








max_value = 0
count = 0
check = []
for i in range(len(array)-1, -1, -1):
    if array[i] < max_value:
        compare = check.pop()
        now = array[i]
        count_left = 0
        count_right = 0
        for j in range(len(check)):
            if check[j] > now:
                count_left += 1
        for j in range(len(array[:i])):
            if array[j] < compare:
                count_right += 1
        if count_left > count_right:
            check.append(compare)
        else:
            check.append(now)
        count += 1
    else:
        check.append(array[i])
        max_value = array[i]
#     print(check)
# print(count)