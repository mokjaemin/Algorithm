

# 실전문제 3. 바닥공사
# 바닥 크기 : Nx2
# 덮개 크기 : 1x2(1) or 2x1(2) or 2x2(3)
# 출력 : 다 덮는 경우의 수 % 796796 -> 즉, 나머지를 출력

# 답변
n = int(input("입력 : "))
a = [1, 3, 5]
for i in range(3, n):
    a.append(a[i-2]*7)
print(a)


# 답안
d = [0]*10
d[1]=1
d[2]=3
for i in range(3, n+1):
    d[i] = d[i-1] + 2 * d[i-2]
print(d)