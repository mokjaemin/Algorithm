
# 실전문제 3 - 1일 될 때까지
# 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
# 문제
# N과 K가 주어질 때 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최소 횟수를 구하는
# 프로그램을 작성하시오.

# 룰
# 단, 두번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다.
# 1. N에서 1을 뺀다.
# 2. N을 K로 나눈다.

# 입력 조건
# N(2~100,000), K(2~100,000), 자연수, N>=K

# 나의 답안
# n, k = map(int, input().split())
# count = 0
# while(1):
#     n = n/k
#     count += 1
#     if(n != int(n)):
#         n = n*k
#         n -= 1
#     if(n == 1):
#         print(count)
#         break

# 아이디어 : 최대한 많이 나누기

# 답안 1
# n, k = map(int, input().split())
# result = 0

# while n >= k:
#     while n % k !=0:
#         n -= 1
#         result += 1
#     n //= k
#     result += 1
# while n > 1:
#     n -= 1
#     result += 1
# print(result)

# 답안 2
# 만약 N이 100억 이상이라면?
# 이해는 안되는데 예시 넣어보면 말은 됨.
# n, k = map(int, input().split())
# result = 0
# while True:
#     target = (n//k)*k #
#     result += (n-target)
#     n = target
#     if n < k:
#         break
#     result += 1
#     n //= k
# result += (n-1)
# n //= k