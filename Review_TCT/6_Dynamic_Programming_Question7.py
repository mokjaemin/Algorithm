



# 퇴사

n = 7
time = [0, 3, 5, 1, 1, 2, 4, 2]
money = [0, 10, 20, 10, 20, 15, 40, 200]
check = [0]*(n+1) # i번째 날부터 마지막 날까지 낼 수 있는 최대 이익
max_value = 0

for i in range(n, 0, -1):
    newDate = time[i] + i # 이번에 상담했을 때 다시 상담이 가능한 날짜
    if newDate <= n:
        check[i] = max(money[i] + check[newDate], max_value)
        max_value = check[i]
    else:
        check[i] = max_value










# for i in range(n-1, -1, -1): # 뒤에서 부터 확인
#     # 현재 날짜 + 걸리는 기간, 즉 이번 상담을 마치고 다음 상담 가능한 날부터 이익 합친 것
#     now = time[i] + i
#     if now <= n:
#         check[i] = max(money[i] + check[now], max_value)
#         max_value = check[i]
#     else: # 범위를 벗어나면 적용하지 않음
#         check[i] = max_value
#     print(check)
# print(max_value)
