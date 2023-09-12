

# 실전문제 1 - 위에서 아래로
# 입력 1 -> 수열의 크기
# 입력 2 -> 첫번째 수
# 입력 3 -> 두번째 수 ...

# 출력 - 내림차순 정렬

n = int(input("입력 : "))
num = []
for i in range(n):
    num.append(int(input("입력 : ")))
print(sorted(num, reverse=True))