

# 실전 문제 2 - 개미전사
# 일렬로 된 창고에서 곡식을 터는데 예를들어, 창고3을 털면 창고2와 창고4는 털 수 없음
# 최대한 곡식을 많이 털었을때 곡시의 최댓값


# 아이디어 -> d = i까지 창고만 존재한다고 했을때, 얻을 수 있는 최대값
# d1 = a1
# d2 = max(a1, a2)
# d3 = max(d2, a3+d1)
# d4 = max(d3, a4+d2)
# d5 = max(d4, a5+d3)
# d6 = max(d5, a6+d4) 
n = int(input("입력 : "))
arr = list(map(int, input("입력 : ").split()))
d = [0]*100
print(arr)
d[0] = arr[0]
d[1] = arr[1]

for i in range(2, n):
    d[i] = max(d[i-1], d[i-2]+arr[i])

print(d[n-1])