


# 실전문제 4. 효율적인 화페 구성
# 화폐가치 <= 10000
# 입력1 : 화폐 종류 수, 만들 금액
# 입력2 : 화폐 종류들

# 이해 예시
# 2, 3, 5원을 사용해 7원 만들기
# 인덱스    0  1  2  3  4  5  6  7
# 값       0  0  0  0  0  0  0  0
# 2원사용   0  0  1  0  2  0  3  0
# 3원사용   0  0  1  1  2  2  2  3  -> 2원과 3원 사용 했을때 최소 코인의 개수이다.
# 5원사용   0  0  1  1  2  1  2  2  -> 2원과 3원, 5원 사용 했을때 최소 코인의 개수이다.

# n, m = map(int, input("입력 : ").split())
# arr = []
# for i in range(n):
#     arr.append(int(input("입력 : ")))

# d = [10001] * (m+1)
# d[0] = 0
# for i in range(n):
#     for j in range(arr[i], m+1):
#         if d[j - arr[i]] != 10001:
#             d[j] = min(d[j], d[j- arr[i]] + 1)
# if d[n] == 10001:
#     print(-1)
# else:
#     print(d[m])


# 아이디어 : 8원을 사용하여 10원을 만들려 할때, 예전에 2원을 만들었던 경우가 있다면,
# 그 수에 8을 더해 10원을 만들수 있으므로 2원을 만드는 최소의 수 + 1
n, m = map(int, input("입력 : ").split())
arr = []
for i in range(n):
    arr.append(int(input("입력 : ")))

d = [10001] * (m+1)
d[0] = 0

for i in arr: # 화폐 하나하나 불러옴
    for j in range(i, m+1): # i원부터 보는 이유 -> i원보다 작으면 짜피 사용 못함
        if d[j-i] != 1001: # 없어도 됨.
            d[j] = min(d[j], d[j-i]+1)
print(d[0:m+1])