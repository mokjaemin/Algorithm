
# 1이 될 때까지

n = int(input("입력 : "))
k = int(input("입력 : "))

count = 0
while n != 1:
    if n % k == 0:
        n /= k
        count += 1
    else:
        n -= 1
        count += 1
    print(n)
print(n)
print(count)