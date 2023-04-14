



# 성냥개비 - 백준
# 해결 못함




# 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
INF = int(1e9)
num = [6, 2, 5, 5, 4, 5, 6, 3, 7, 6]
dp = [[] for _ in range(100)]
start = 0
for i in num:
    dp[i].append(start)
    start += 1

# n = int(input())
# number = []
# for i in range(n):
#     number.append(int(input()))

n = 4
number = [3,6,7,15]


until = max(number)+1

for i in range(2, until):
    min_value = INF
    max_value = 0
    for j in dp[i]:
        if j == 0:
            continue
        min_value = min(j, min_value)
        max_value = max(j, max_value)
    for j in range(i-1, 0, -1):
        check1 = j
        check2 = i-j
        for value1 in dp[check1]:
            for value2 in dp[check2]:
                value = str(value1)+str(value2)
                if value[0] == '0':
                    continue
                value = int(str(value1)+str(value2))
                min_value = min(value, min_value)
                max_value = max(value, max_value)
    if 0 in dp[i]:
        dp[i] = [0]
    else:
        dp[i] = []

    dp[i].append(min_value)
    dp[i].append(max_value)

    # if i in number:
    #     if dp[i][0] == 0:
    #         print(dp[i][1], dp[i][2])
    #         continue
    #     print(dp[i][0], dp[i][1])

print(dp[0:15])

