

# 메모이 제이션, 탑다운 방식
# 피보나치 수열

check= [0]*100

def fibo(x):
    print("f(", x, ")")
    if x == 1 or x == 2:
        return 1
    if check[x] != 0:
        return check[x]
    else:
        check[x] = fibo(x-1) + fibo(x-2)
        return check[x]
print(fibo(10))


# 보텀업 방식
check = [0]*100

check[1] = 1
check[2] = 1

n = 99

for i in range(3, n+1):
    check[i] = check[i-1] + check[i-2]
print(check[n])