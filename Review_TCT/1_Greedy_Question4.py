

# 4. 만들 수 없는 금액

# n = int(input("입력 : "))
# arr = list(input("입력 : ").split())
# check = [0]*(100001*n)

# def find(a, findAll):
#     for i in arr:
#         check[int(i)+a] = 1
#     findAll += 1
#     print(findAll, "회차")
#     print(check[:10])
#     if findAll < n:
#         find(int(i), findAll)

# findAll = 0
# find(0, findAll)
# print(check[:20])
# for i in range(1, len(check)):
#     if check[i] == 0:
#         print(i)
#         break


# 답안
n = int(input("입력 : "))
arr = list(input("입력 : ").split())
arr = sorted(arr)
target = 1
for i in arr:
    if target < i:
        break
    else:
        target += i # target+1 은 다음에 확인할 가능 금액

# 1원 있어? 있으면 2원은 못만들겠네
# 2원 있어? 있으면 1원도 있고 2원도 있으니 4원부터는 못만들겟네?
