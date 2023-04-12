



# 병사 배치하기



# soldiers = [50, 20, 30, 10, 20, 10]
# n = len(soldiers)
n = int(input())
soldiers = list(map(int,input().split()))
dp = [1]*(n)

for i in range(n-2, -1, -1):
    for j in range(i+1, n):
        if soldiers[j] < soldiers[i]:
            dp[i] = max(dp[i], dp[j]+1)
print(n-max(dp))
