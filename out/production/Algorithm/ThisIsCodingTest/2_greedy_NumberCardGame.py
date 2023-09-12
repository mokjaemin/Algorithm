
# 실전문제 2 - 숫자 카드 게임
# 여러개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한장을 뽑는 게임

# 룰
# 1. 숫자가 쓰인 카드들이 NxM 형태로 놓여있다. 이때 N은 행의 개수를 의미하며, M은 열의 개수를 의미한다.
# 2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
# 3. 그다음 선택된 행에 포함된 카드들 중 숫자가 낮은 카드를 뽑아야 한다.
# 4. 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을
# 고려하여 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.

# 조건
# 1. 첫째 줄에 숫자 카드들이 놓인 행의 개수 N과 열의 개수 M이 공백을 기준으로 하여 각각 자연수로 주어진다.
# (1~100)
# 2. 둘째 줄부터 N개의 줄에 걸쳐 각 카드에 적힌 숫자가 주어진다. 각 숫자는 1~10000 자연수

# 나의 답안 1
# n, m = map(int, input().split())
# metric = []
# result = []
# for i in range(0, n):
#     metric.append(list(map(int, input().split())))
#     metric[i].sort()
#     result.append(metric[i][0])
# result.sort()
# print(result[0])


# 문제 아이디어
# 각 행마다 가장 작은 수를 찾은 뒤에 그 수 중에서 가장 큰 수를 찾는다.

# 답안 1
# n, m = map(int, input().split())
# result = 0
# for i in range(n):
#     data = list(map(int, input().split()))
#     min_value = min(data) # min - 가장 작은 것
#     result = max(result, min_value) # max - 둘 중 누가 큰지 비교

# 답안 2
# n, m = map(int, input().split())
# result = 0
# for i in range(n):
#     datas = list(map(int, input().split()))
#     min_value = 10001
#     for data in datas:
#         min_value = min(data, min_value) # 가장 작은 수 기록
#     result = max(result, min_value) # 가장 큰 수 기록
# print(result)