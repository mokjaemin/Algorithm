

n = 1260
count = 0
coins = [500, 100, 50, 10]

for coin in coins:
    print("사용한 코인 : ", coin)
    print("사용 개수 : ", n//coin)
    count += n//coin
    n %= coin
print("사용한 총 동전의 수 : ", count)