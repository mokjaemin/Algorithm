


# 숫자 카드 게임

import time
n, m = map(int, input("입력 : ").split())
data = []
result = []
for i in range(n):
    data.append(list(map(int, input("입력 : ").split())))
    result.append(min(data[i]))

start_time = time.time()
print(max(result))
end_time = time.time()
print("time : ", end_time - start_time)

