

# 예제 1. 거스름돈
# n = int(input("입력 : "))
# count = 0
# while n != 0:
#     if n >= 500:
#         n -= 500
#         count += 1
#         print("500")
#         continue
#     elif n >= 100:
#         n -= 100
#         count += 1
#         print("100")
#         continue
#     elif n >= 50:
#         n -= 50
#         count += 1
#         print("50")
#         continue
#     elif n >= 10:
#         n -= 10
#         count += 1
#         print("10")
#         continue
# print(count)
# 문제점 : 너무 복잡


# 답안
# n = 1260
# count = 0
# coin_types = [500, 100, 50, 10]
# for coin in coin_types:
#     count += n//coin
#     print("count : ", count)
#     n %= coin
#     print("n : ", n)
# print(count)



# 실전문제 1. 큰 수의 법칙
# # array = []
# # array.append(list(map(int, input("입력 : ").split())))
# array = list(map(int, input().split()))
# # array = sorted(array[0], reverse=True)
# array.sort()
# result = 0
# count = 0 
# for i in range(p):
#     if count != m:
#         result += array[0]
#         print(result)
#         count += 1
#     elif count == m:
#         result += array[1]
#         print(result)
#         count = 0
    
import time
n, m, k = map(int, input("입력 : ").split())
array = list(map(int, input().split()))
start_time = time.time()
array.sort(reverse=True)
result = (m//(k+1)) * (array[0]*3 + array[1])
result += (m%(k+1)) * array[0]
print(result)
end_time = time.time()
print(end_time - start_time)