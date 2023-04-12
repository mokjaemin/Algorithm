



# 퇴사

n = 10
# graph = [
#     [5, 10],
#     [5, 9],
#     [5, 8],
#     [5, 7],
#     [5, 6],
#     [5, 10],
#     [5, 9],
#     [5, 8],
#     [5, 7],
#     [5, 6]
# ]
n = 7
graph = [
    [3, 10],
    [5, 20],
    [1, 10],
    [1, 20],
    [2, 15],
    [4, 40],
    [2, 200]
]

n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))

dp = [0]*(n+1)
max_value = 0

for i in range(n-1, -1, -1):
    money = graph[i][1]
    end_work = graph[i][0]+i
    if end_work <= n:
        dp[i] = max(dp[end_work]+money, max_value)
        max_value = dp[i]
    else:
        dp[i] = max_value
print(dp[0])

        




# check = [0]*(n+1)
# max_value = 0

# for i in range(n, 0, -1):
#     again_time = graph[i][0]+i
#     money = graph[i][1]
#     if again_time <= n:
#         check[i] = max(money+check[again_time], max_value)
#         max_value = check[i]
#     else:
#         check[i] = max_value
#     print(check)

