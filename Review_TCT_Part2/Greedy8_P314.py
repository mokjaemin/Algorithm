

# 만들 수 없는 금액

# num = map(int, input("입력 : "))
# num.sort()
# target = 1
# for i in num:
#     if target < i:
#         break
#     target += i
# print(target)


def solution(players, callings):
    for i in range(len(callings)):
        for j in range(len(players)):
            if players[j] == callings[i]:
                if j-1 >= 0:
                    players[j-1], players[j] = players[j], players[j-1]
                break
    return players


players = ["mumu", "soe", "poe", "kai", "mine"]
callings = ["kai", "kai", "mine", "mine"]
result = ['mumu', 'kai', 'mine', 'soe', 'poe']
print(solution(players, callings))