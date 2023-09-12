


# 못생긴수 
n = 10
ugly = [0]*n
ugly[0] = 1
count2 = count3 = count5 = 0
next2, next3, next5 = 2, 3, 5

for i in range(1, n):
    ugly[i] = min(next2, next3, next5)
    if ugly[i] == next2:
        count2 += 1
        next2 = ugly[count2]*2
    if ugly[i] == next3:
        count3 += 1
        next3 = ugly[count3]*3
    if ugly[i] == next5:
        count5 += 1
        next5 = ugly[count5]*5

print(ugly)
print(ugly[n-1])