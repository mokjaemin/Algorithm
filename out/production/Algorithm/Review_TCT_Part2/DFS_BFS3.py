

# 특정 거리의 도시 찾기

from collections import deque
def solution(n, k, x, array):
    distance = [-1]*(n+1)
    distance[x] = 0
    queue = deque()
    queue.append(x)
    while queue:
        now = queue.popleft()
        for i in array[now]:
            if distance[i] == -1:
                distance[i] = distance[now] + 1
                queue.append(i)
    result = []
    for i in range(len(distance)):
        if distance[i] == k:
            result.append(i)
    return result

n, m, k, x = map(int, input().split())
array = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    array[a].append(b)

result = solution(n, k, x, array)
if len(result) == 0:
    print("-1")
else:
    for i in result:
        print(i)