

# 무지의 먹방 라이브


# 나의 답변
# def solution(food_times, k):
#     n = len(food_times)
#     count = 0
#     for i in range(k):
#         for j in range(n):
#             if i % n == j:
#                 if food_times[j] <= 0:
#                     count += 1
#                 food_times[j] -= 1
#                 print(food_times)
#                 if i == k-1:
#                     answer = j+count+1
#                     if answer >= n:
#                         answer %= n
#                 break
#     return answer

# food_times = list(map(int, input("입력 : ").split()))
# k = int(input("입력 : "))
# result = solution(food_times, k)
# print(result+1)

from collections import deque
queue = deque()
def solution(food_times, k):
    queue = deque()
    for i in range(len(food_times)):
        queue.append((food_times[i], i+1))
    for j in range(k+1):
        duration, now = queue.popleft()
        if j == k:
            return now 
        duration -= 1
        print(duration, now)
        if duration > 0:
            queue.append((duration, now))


food_times = list(map(int, input("입력 : ").split()))
k = int(input("입력 : "))
result = solution(food_times, k)
print(result)