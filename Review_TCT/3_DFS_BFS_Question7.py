

# 연산자 끼워넣기

# 기본 정보
from itertools import permutations
from collections import deque
n = 2
nums = [5, 6]
operators = [2, 1, 1, 0]
operator = []
count = 0 
for i in operators:
    for j in range(i):
        operator.append(count)
    count += 1


# 덧(0), 뺄(1), 곱(2), 나(3)
per_operator = list(permutations(operator, len(operator)))
per_nums = list(permutations(nums, len(nums)))


final = []
for i in per_nums:
    for j in per_operator:
        queue = deque()
        for k in range(n):
            queue.append(i[k])
            if k <= n-2:
                queue.append(j[k])
        result = 0
        index = 0
        for a in range(len(queue)):
            if a == 0:
                cost = queue.popleft()
                result += cost
            else:
                if a % 2 == 0:
                    cost = queue.popleft()
                    if index == 0:
                        result += cost
                    elif index == 1:
                        result -= cost
                    elif index == 2:
                        result *= cost
                    else:
                        if result < 0 and cost > 0:
                            result = -result
                            result //= cost
                            result = -result
                        elif result > 0 and cost < 0:
                            cost = -cost
                            result //= cost
                            result = -result
                        else:
                            result //= cost
                else:
                    operator = queue.popleft()
                    if operator == 0:
                        index = 0
                    elif operator == 1:
                        index = 1
                    elif operator == 2:
                        index = 2
                    else:
                        index = 3
        final.append(result)
        # break
    break
        
print(max(final))
print(min(final))

