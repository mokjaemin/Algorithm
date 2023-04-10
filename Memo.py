

# 'b'를 숫자로 변경
column = int(ord('b') - int(ord('a'))) + 1

# 알파벳인지 확인 Boolean
test = 'A'
print(test.isalpha())

# 리스트의 특정 인덱스 삭제
test = [1, 2, 3]
test.pop(2)
print(test)

# 조합
# a리스트에서 m개를 골라 조합 만듬
from itertools import combinations
a = [1, 2, 3]
m = 2
candidates = list(combinations(a, m))

# DFS/BFS
from collections import deque
stack = []
stack.append()
stack.pop()
queue = deque()
queue.append()
queue.popleft()

# visited 생성
array = []
visited = [[False]*len(array[0]) for _ in range(len(array))]