                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          


# 치킨 배달
# n = int(input("입력 : "))
n = 5
# m = int(input("입력 : "))
m = 2
# graph = []
# for i in range(n):
#     graph.append(list(map(int, input("입력").split())))
graph = [[0, 2, 0, 1, 0], [1, 0, 1, 0, 0], [0, 0, 0, 0, 0], [2, 0, 0, 1, 1], [2, 2, 0, 1, 2]]
house_pos = []
chicken_pos = []
chicken_value = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            house_pos.append([i+1, j+1])
        elif graph[i][j] == 2:
            chicken_pos.append([i+1, j+1])
total = [[] for i in range(len(chicken_pos))]
k = 0
for i in house_pos:
    for j in chicken_pos:
        total[k].append(abs(i[0]-j[0]) + abs(i[1]-j[1]))
        k += 1
    k = 0

print(total)
import itertools
if len(total) <= m:
    result = 0
    for j in total:
        result += min(j)
    print(result)

else:
    arr = [i for i in range(len(chicken_pos))]
    per = list(itertools.permutations(arr, m))
    result = 0
    final = 0
    min_value = 100*m
    min_value_final = 100*m
    final_list = []
    for i in range(len(total)):
        for j in per:
            for k in j:
                result = total[i][k]
                if result <= min_value:
                    min_value = result
            final += min_value
        final_list.append(final)
        final = 0
    print(final_list)
