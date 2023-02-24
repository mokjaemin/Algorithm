

# 인구 이동

# 그래프 정보
l1 = 5
r1 = 10
graph1 = [
    [10, 15, 20],
    [20, 30, 25],
    [40, 22, 10]
]
l2 = 40
r2 = 50
graph2 = [
    [50, 30],
    [20, 40]
]
l3 = 20
r3 = 50
graph3 = [
    [50, 30],
    [30, 40]
]
l4 = 10
r4 = 50
graph4 = [
    [10, 100, 20, 90],
    [80, 100, 60, 70],
    [70, 20, 30, 40],
    [50, 20, 100, 10]
]



# 인접마다 차이 구하고 인접 리스트 만들기
def make_closed(graph, l, r):
    closed = [[False for i in range(len(graph))] for i in range(len(graph))]
    for i in range(len(graph)):
        for j in range(len(graph)-1):
            if l <= abs(graph[i][j] - graph[i][j+1]) <= r:
                closed[i][j] = True
                closed[i][j+1] = True

    for i in range(len(graph)):
        for j in range(len(graph)-1):
            if l <= abs(graph[j][i] - graph[j+1][i]) <= r:
                closed[j][i] = True
                closed[j+1][i] = True
    print("closed : ", closed)
    return closed

def change_graph(graph, l, r):
    len_closed = 0
    result = 0
    closed = make_closed(graph, l, r)
    for a in range(len(graph)):
        for b in range(len(graph)):
            if closed[a][b] == True:
                result += graph[a][b]
                len_closed += 1
    if len_closed == 0:
        return False
    result //= len_closed
    print("result : ", result)
    print("len_closed : ", len_closed)

    for a in range(len(graph)):
        for b in range(len(graph)):
            if closed[a][b] == True:
                graph[a][b] = result

    for i in graph:
        print(i)
    print("")
    return True

print("초기 함수")
for i in graph4:
    print(i)
print("")

final = True
while final:  
    final = change_graph(graph4, l4, r4)