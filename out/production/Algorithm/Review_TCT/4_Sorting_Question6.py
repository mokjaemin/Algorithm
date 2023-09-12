


# 실패율

n = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
count = [0]*(n+1)
stop = [0]*(n+1)
result = []
for i in range(1, n+1):
    for stage in stages:
        if stage >= i:
            count[i] += 1
        if stage == i:
            stop[i] += 1
for i in range(1, n+1):
    result.append([stop[i]/count[i], i])
result.sort(key = lambda x : x[0], reverse=True)
for i in result:
    print(i[1], end=" ")
print(" ")


# 답
def solution(N, stages):
    answer = []
    length = len(stages)

    for i in range(1, N+1):
        count = stages.count(i)

        if length == 0:
            fail = 0
        else:
            fail = count/length

        answer.append((i, fail))
        length -= count
