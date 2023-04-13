

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

# 입력 받는 방법 특이하니 다시 보자
t = int(input())
final_test = []
num = []
for i in range(t):
    n, m = map(int, input().split())
    test = list(map(int, input().split()))

    dp = []
    index = 0
    for i in range(n):
        dp.append(test[index:index+m])
        index += m


# 역 for
# 4 ~ 0
n = 5
for i in range(n-1, -1, -1):
    print(i)


# 리스트에서 특정값의 인덱스 찾기
# 정렬된 배열에서 사용 가능하다. 
# 가장 왼쪽 인덱스, 가장 오른쪽 인덱스를 알아내 해당 값을 가지는 수를 구할 수 도 있다.
# 해당 예시는 배열에서 2의 가장 왼쪽 인덱스, 가장 오른쪽 인덱스를 구한다
# 만약 배열에 해당 값이 없다면 각각 0을 반환한다.
# 정렬된 ["abc", "acd", "acs"]가 있다고 가정할때 aaa ~ azz까지 해당되는 개수도 반환가능
from bisect import bisect_left, bisect_right
left_index = bisect_left(array, 2)
right_index = bisect_right(array, 2)
result = right_index-left_index



# 문자열 역 처리
result[::-1]

# 문자열 대체
result.replace('?', 'a')


# 인접 리스트
graph = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 인접 행렬
INF = int(1e9)
graph = [[INF]*(n+1) for _ in range(n+1)]
for i in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1