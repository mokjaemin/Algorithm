


# 무지의 먹방 라이브

# def solution(food_times, k):
#     answer = 0
#     now = 0
#     for i in range(k+1):
#         check = now
#         while(1):
#             if now >= len(food_times):
#                 now = 0
#             if food_times[now] > 0:
#                 if i == k:
#                     return now
#                 food_times[now] -= 1
#                 now += 1
#                 break
#             else:
#                 now += 1
#                 if now == check:
#                     return -1
#         print(food_times)
# food_times = [3, 1, 2]
# k = 5
# print(solution(food_times, k))

import heapq

def solution(food_times, k):
    # 시간내에 음식을 다 먹을 경우
    if sum(food_times) <= k:
        return -1
    
    # 우선순위 큐 설정
    q = []
    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i+1))
    
    sum_value = 0 # 먹기 위해 사용한 시간
    previous = 0 # 직전에 다 먹은 음식 시간
    length = len(food_times) # 남은 음식의 개수

    while sum_value + ((q[0][0] - previous)*length) <= k:
        now = heapq.heappop(q)[0]
        sum_value += (now - previous)*length
        length -= 1
        previous = now
    result = sorted(q, key=lambda x:x[1])
    return result[(k-sum_value)%length][1]


food_times = [3, 1, 2]
k = 5
print(solution(food_times, k))