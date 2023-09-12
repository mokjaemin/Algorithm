


# 서로소 집합 알고리즘
# 개선 전 부모 찾기
# def find_parent(parent, x):
#     if parent[x] != x:
#         return find_parent(parent, parent[x])
#     return parent[x]

# 개선된 부모 찾기(경로 압축법)
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b



n = 6
m = 4
node = [1, 2, 3, 4, 5, 6]
parent = [0]*(n+1)
for i in node:
    parent[i] = i

lines = [[1, 4], [2, 3], [2, 4], [5, 6]]

for line in lines:
    union_parent(parent, line[0], line[1])


# for i in parent:
#     if i != 0:
#         print(i, end=" ")
# print(" ")


# for i in range(1, n+1):
#     print(find_parent(parent, i), end=" ")
# print(" ")




# 크루스칼 알고리즘
import heapq
q = []
heapq.heappush(q, [29, (1, 2)])
heapq.heappush(q, [75, (1, 5)])
heapq.heappush(q, [35, (2, 3)])
heapq.heappush(q, [34, (2, 6)])
heapq.heappush(q, [7, (3, 4)])
heapq.heappush(q, [23, (4, 6)])
heapq.heappush(q, [13, (4, 7)])
heapq.heappush(q, [53, (5, 6)])
heapq.heappush(q, [25, (6, 7)])


parent = [0, 1, 2, 3, 4, 5, 6, 7]
result = 0

def find_parent1(parent, node):
    if parent[node] != node:
        parent[node] = find_parent1(parent, parent[node])
    return parent[node]


def union_parent1(parent, node1, node2):
    parent1 = find_parent1(parent, node1)
    parent2 = find_parent1(parent, node2)
    if parent1 > parent2:
        parent[node2] = parent1
    else:
        parent[node1] = parent2
    print(parent)

while q:
    cost, node = heapq.heappop(q)
    node1, node2 = node[0], node[1]
    if find_parent1(parent, node1) != find_parent1(parent, node2):
        result += cost
        union_parent1(parent, node1, node2)
print(result)


    