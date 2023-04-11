


# 연산자 끼워넣기

# n = input()
n = 6
# num = list(map(int, input().split()))
num = [1, 2, 3, 4, 5, 6]
# plus, minus, times, division = map(int, input().split())
plus, minus, times, division = 2, 1, 1, 1

array = ['+']*plus
array += ['-']*minus
array += ['*']*times
array += ['/']*division

from itertools import permutations
check = list(permutations(array, len(array)))


final_list = []
real_check = []
for test in check:
    if test in real_check:
        continue
    real_check.append(test)
    result = 0
    result += num[0]
    for i in range(1, len(num)):
        if test[i-1] == '+':
            result += num[i]
        elif test[i-1] == '-':
            result -= num[i]
        elif test[i-1] == '*':
            result *= num[i]
        else:
            if result < 0:
                result = -result
                result //= num[i]
                result = -result
            result //= num[i]
    final_list.append(result)


print(max(final_list))
print(min(final_list))



n = int(input())
data = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

min_value = 1e9
max_value = -1e9

def dfs(i, now):
    global min_value, max_value, add, sub, mul, div

    if i == n:
        min_value = min(min_value, now)
        max_value = max(max_value, now)
    else:
        if add > 0:
            add -= 1
            dfs(i+1, now+data[i])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(i+1, now-data[i])
            sub += 1
        if mul > 0:
            mul -= 1
            dfs(i+1, now*data[i])
            mul += 1
        if div > 0:
            div -= 1
            dfs(i+1, int(now/data[i]))
            div += 1

# 1-연산의 첫번째임을 의미, 숫자리스트의 첫번째 인덱스
dfs(1, data[0])
print(max_value)
print(min_value)