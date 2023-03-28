


# 서로소 집합 알고리즘
def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
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


for i in parent:
    if i != 0:
        print(i, end=" ")
print(" ")


for i in range(1, n+1):
    print(find_parent(parent, i), end=" ")
print(" ")



# for line in lines:
#     if parent[line[0]] > parent[line[1]]:
#         parent[line[0]] = parent[line[1]]
#     elif parent[line[0]] < parent[line[1]]:
#         parent[line[1]] = parent[line[0]]
#     else:
#         continue
# print(parent)



    