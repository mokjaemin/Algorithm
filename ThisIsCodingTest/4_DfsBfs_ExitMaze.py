

# 실전 문제 2. 미로 탈출
# 시작점 (1, 1) - 즉 (0, 0)에서 시작한다.
# 괴물 0, 괴물 없는 부분 1(통로)
# 출구는 (N, M)에 위치
# 미로 탈출을 위한 움직의 최소 칸

from collections import deque
import numpy as np

n, m = map(int, input("입력 : ").split(" "))
graph = []
for i in range(n):
    graph.append(list(map(int, input("입력 : "))))

quene = deque()

def bfs(x , y, idx):
    if x <= -1 or x >= n-1 or y <= -1 or y >= m-1:
        return False
    if(graph[x+1][y] == 1):
        graph[x+1][y] = idx
        quene.append([x+1, y])
    if(graph[x][y+1] == 1):
        graph[x][y+1] = idx
        quene.append([x, y+1])

quene.append([0, 0])
idx = 1
while(len(quene)):
    idx += 1
    print("현재 : ", quene)
    bfs(quene[0][0], quene[0][1], idx)
    print("bfs후 : ", quene)
    quene.popleft()
    print("pop후 : ", quene)

print(graph[n-1][m-1])
new_graph = np.array(graph)
new_graph.reshape(n, m)
print(new_graph)

# 111
# 101
# 101