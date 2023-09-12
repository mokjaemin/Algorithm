




# 치킨 배달

n, m = map(int, input().split())
chicken_pos = []
house_pos = []
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(n):
        if graph[i][j] == 1:
            house_pos.append([i, j])
        if graph[i][j] == 2:
            chicken_pos.append([i, j])


from itertools import combinations
check = list(combinations(chicken_pos, m))
INF = int(1e9)

final_result = []

for chicken in check:
    for i in chicken:
        if i not in chicken_pos:
            graph[i[0]][i[1]] = 0
    
    house_diff = 0
    for house in house_pos:
        min_value = INF
        for chick in chicken:
            min_value = min(min_value, abs(house[0]-chick[0]) + abs(house[1]-chick[1]))
        house_diff += min_value
    final_result.append(house_diff)


    for i in chicken:
        if i not in chicken_pos:
            graph[i[0]][i[1]] = 2

print(min(final_result))