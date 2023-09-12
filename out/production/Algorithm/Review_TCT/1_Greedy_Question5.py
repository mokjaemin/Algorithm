


# 5. 볼링공 고르기
n, m = map(int, input("입력 : ").split())
arr = list(map(int, input("입력 : ").split()))
arrAll = [[i+1, arr[i]] for i in range(0, n)]
count = 0
for i in range(len(arrAll)):
    for j in range(i+1, len(arrAll)):
        if arrAll[i][1] != arrAll[j][1]:
            count += 1
print(count)