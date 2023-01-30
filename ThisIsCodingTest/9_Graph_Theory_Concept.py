

# 그래프 이론

# 1. 서로소 집합

# 답변
# n, m = map(int, input("입력 : ").split())
# array = []
# for i in range(m):
#     index1, index2 = map(int, input("입력 : ").split())
#     array.append((index1, index2))
# parents = [i for i in range(n+1)]
# for i in array:
#     if i[0] > i[1]:
#         parents[i[0]] = i[1]
#     else:
#         parents[i[1]] = i[0]
# print(parents)

# 답안
# 부모찾기 함수
def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x
# union 함수
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
# 노드, 간선 수 받기
v, e = map(int, input().split())
# 부모테이블 초기화
parent = [0]*(v+1)
for i in range(1, v+1):
    parent[i]= i
# 간선 정보 받고 바로 union
for i in range(e):
    a, b = map(int, input().split())
    union_parent(parent, a, b)

print('각 원소가 속한 집합 : ', end='')
for i in range(1, v+1):
    print(find_parent(parent, i), end=' ')
print()
print('부모테이블 : ', end='')
for i in range(1, v+1):
    print(parent[i], end=' ')