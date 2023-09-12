


# 안테나

# 나의 답안
n = 4
house = [5, 1, 7, 9]
final = []
for install in house:
    result = 0
    for pos in house:
        result += abs(install - pos)
    final.append([install, result])
final.sort(key=lambda x : (int(x[1]), int(x[0])))
print(final[0][0])


# 해설
house = [5, 1, 7, 9]
house = sorted(house)
print(house[(len(house)-1)//2])