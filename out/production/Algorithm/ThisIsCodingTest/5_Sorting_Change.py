


# 실전문제 3 - 두배열의 원소 교체
# N개의 원소를 가진 두 배열에서 최대 K번 두 배열의 원소 교체로 첫번째 배열의 합이 최대가 되게 만들어라

n, k = map(int,input("입력").split(" "))
array = []
for i in range(n):
    array.append(list(map(int,input("입력").split(" "))))
for i in range(k):
    array[0] = sorted(array[0])
    array[1] = sorted(array[1], reverse=True)
    # array[0][0], array[1][0] = array[1][0], array[0][0]
print(array)


# 답안
n, k = map(int,input("입력").split(" "))
a = list(map(int,input("입력").split(" ")))
b = list(map(int,input("입력").split(" ")))

a.sort()
b.sort(reverse=True)

for i in range(k):
    if(a[i] < b[i]):
        a[i], b[i] = b[i], a[i]
    else: # for문 빠져나옴
        break
print(sum(a))

# 나와 다른점
# 1. 모든 A가 B보다 큰 경우를 나는 고려하지 못함
# 2. 바꾸고 갱신되는게 아니라 처음 설정된 내용에서 바꿔야함