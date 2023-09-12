

# 실전문제 2. 전보

# 입력 1 : 도시의 개수, 통로의 개수, 메시지를 보내고자 하는 도시 번호
# 입력 2, 3: X에서 다른 특정도시 Y로 메시지가 전달되는 시간 Z
# 출력 : 메시지를 받는 도시의 총 개수, 총 걸리는 시간 출력
# (예를 들어, a도시까지 3시간 b도시까지 4시간 걸릴때 총 걸리는 시간은 4시간)


import heapq
INF = int(1e9)
n, m, start = map(int, input("입력 : ").split())
array = [[] for i in range(n+1)]
for i in range(m):
    sta, des, time = map(int, input("입력 : ").split())
    array[sta].append((time, des))
distance = [INF]*(n+1)


def find_way(start):
    distance[start] = 0
    q = []
    for j in array[start]: # 시작점과 연결된 시간과 노드 정보 불러옴
        heapq.heappush(q, (j[0], j[1])) # 시간, 다음 진행할 노드(현재노드와 연결된 노드중)
        distance[j[1]] = j[0] # 해당 노드까지의 시간 = 시간
    while q: # heapq가 빌때까지
        time, now = heapq.heappop(q) # 현재 진행할 노드를 불러옴
        if distance[now] < time: # 이미 처리한적 있으면 pass
            continue
        for j in array[now]: # 현재 진행할 노드와 연결된 노드들 불러옴
            if distance[j[1]] > (j[0]+distance[now]): 
                distance[j[1]] = j[0]+distance[now]
            heapq.heappush(q, (j[0], j[1]))

find_way(start)
print(distance)
# 헷갈리는 것 : 다음에 진행할 노드들을 headq에 넣는 것임을 잊지 말자.


find_way(start)