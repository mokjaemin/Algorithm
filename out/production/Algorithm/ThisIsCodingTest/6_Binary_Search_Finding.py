

# 실전문제 1. 부품 찾기

# 입력 1. 가게에 있는 부품 종류의 개수(N)
# 입력 2. N개의 부품의 부품 번호
# 입력 3. 손님이 찾는 부품의 개수
# 입력 4. 손님이 찾는 부품 번호


# 나의 답안 - 이진탐색, 재귀함수
# n = int(input("입력 : "))
# num = list(map(int, input("입력 : ").split()))
# m = int(input("입력 : "))
# f_num = list(map(int, input("입력 : ").split()))

# num = sorted(num)
# def binary_search(f_num, num, start, end):
#     if start > end:
#         return "no"
#     mid = (start+end)//2
#     if num[mid] == f_num:
#         return "yes"
#     elif num[mid] > f_num:
#         return binary_search(f_num, num, start, mid-1)
#     else:
#         return binary_search(f_num, num, mid+1, end)

# result = []  
# for i in range(m):
#     result.append(binary_search(f_num[i], num, 0, n-1))
# print(result)


# 다른 방법 - 계수정렬
# n = int(input("입력 : "))
# array = [0]*10001
# for i in input("입력 : ").split():
#     array[int(i)] = 1
# m = int(input("입력 : "))
# x = list(map(int, input("입력 : ").split()))

# for i in x:
#     if(array[i] == 1):
#         print("yes", end=" ")
#     else:
#         print("no", end=" ")


# 다른 방법 - 집합 자료형 {}
n = int(input("입력 : "))
array = set(map(int, input("입력 : ").split()))

m = int(input("입력 : "))
x = list(map(int, input("입력 : ").split()))

for i in x:
    if i in array: # 해당 부품이 array안에 존재하는지 확인
        print("yes", end=" ")
    else:
        print("no", end=" ")