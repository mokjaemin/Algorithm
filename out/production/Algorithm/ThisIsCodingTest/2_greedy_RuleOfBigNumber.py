
# 실전문제 1 - 큰수의 법칙
# 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
# 배열의 크기 N, 숫자가 더해지는 횟수 M, 한 숫자가 연산에 포함될 수 있는 횟수 K
# 조건
# 1. 2<=N<=1000, 1<=M<=10,000, 1<=K<=10,000 자연수, 자연수는 공백으로 구분
# 2. 둘째 줄에 N개의 자연수가 주어진다. 각 자연수는 공백으로 구분한다. 단, 각각의 자연수는 1이상 10,000이하
# 3. 입력으로 주어지는 K는 항상 M보다 작거나 같다
# 출력 - 첫째 줄에 큰수의 법칙에 다라 더해진 답을 출력한다. 

# 나의 답변
# import random
# while(1):
#     n, m, k = map(int,input("입력 : ").split())
#     sum = 0
#     count = 0
#     if((n<2 or n>1000) or (m<1 or m>10000) or (k > m)):
#         break
#     list = []
#     for i in range(0, n):
#         list.append(random.randint(1, 10000))
#     list.sort()
#     spare = list[-1]
#     for i in range(0, m):
#         sum += list[-1]
#         count += 1
#         if(count == k): # 큰수 k번, 두번째 큰수 1번으로 하면되는데 둘 다 k번씩 더해서 틀림
#             if(list[-1] == spare):
#                 del list[-1]
#             elif(list[-1] != spare):  
#                 list.append(spare)
#             count = 0
#     print(sum)
#     break

# 답안
# n, m, k = map(int, input("input : ").split())
# data = list(map(int, input("list : ").split()))

# data.sort()
# first = data[-1]
# second = data[-2]
# result = 0

# while True:
#     for i in range(0, k):
#         if(m == 0):
#             break
#         result += first
#         m -= 1
#     if(m == 0):
#         break
#     result += second
#     m -= 1

# print(result)

# 발전
# 큰 수가 사용되는 횟수를 구하고 이용
n, m, k = map(int, input("input : ").split())
data = list(map(int, input("list : ").split()))
data.sort()

first = data[-1]
second = data[-2]

# 큰 수가 사용된 횟수
count = int(m/(k+1))*k
count += m%(k+1)

result = count * first
result += (m-count)*second

print(result)