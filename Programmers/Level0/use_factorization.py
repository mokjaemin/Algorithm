

# 소인수 분해

def solution(x):
    start = 2
    answer = []
    while start <= x:
        if x % start == 0:
            if start not in answer:
                answer.append(start)
            x //= start
            continue
        start += 1
    return answer