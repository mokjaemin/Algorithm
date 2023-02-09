# 기본 문법 정리

# 1. 나눗셈 관련
print(5//3) # 소수점 버림
print(5/3)
print(5%3)

# 2. 해당 문자 포함되었는지
# 타입 맞춰줘야 함
n = "3"
if(n in "33"):
    print("yes")

# 3. 영어 문자열의 아스키 코드 상 순서 받기
# 예를들어, a-1, b-2
column = int(ord("a") - int(ord('a'))) + 1
print(column)

# 4. 리스트를 넘파이로
import numpy as np
list = []
list = np.array(list)

# 5. 맵 만들기
m = 5 # 행
n = 4 # 열
d = [[0]*m for _ in range(n)]

# 6. 마지막 원소부터 출력 
stack = []
print(stack[::-1])

# 7. 띄워쓰기 마지막에 추가
print(1, end=" ")

# 8. not 사용
if not True: # ! 대신 사용하자.
    print("a") 

# 9. deque 사용
from collections import deque
start = 1
quene = deque({start})
quene.append()
quene.popleft()
# quene이 빌때까지
while(quene):
    print("아직 있음")
# 입력 받을때
quene.append((1, 1)) # 1행 1열


# 10. 입력 받아 그래프 생성
# 예를 들어, 그래프의 크기 입력받은 후 3333 입력받아 맵의 첫줄로 입력
x, y = map(int, input("입력 : ").split())
graph = []
for i in range(x):
    graph.append(list(map(int, input("입력 : "))))
# graph.append(list(map(int, input("입력 : ").split()))) 가능
# 저번에 graph 대신 map이라는 이름을 사용했는데 함수랑 헷갈려함.
# 따라서 map 쓰지 말자.
# 입력시 list로 입력해야 함.
# split 쓸때 조심, 만약 split 쓰고 입력시 띄어쓰기로 안받으면 하나의 데이터가 되어버림


# 11. continue
# for 안에 continue는 for문을 나감
for i in range(4):
    if(i == 1):
        continue
    print(i)


# 12. swap - 위치 바꾸기
array = [3, 5]
array[0], array[1] = array[1], array[0]


# 13. 마이너스 반복문
for i in range(10, 0, -1):
    print(i)


# 14. 정렬
array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]
array = sorted(array) # 오름 차순(점점 오름)
array = sorted(array, reverse=True) # 내림 차순(점점 내려감)
array.sort() # 리스트 객체의 내장 함수
data = sorted(array, key=lambda array:array[1], reverse=True) # 기준 정렬, 2차원일경우


# 15. 리스트 생성없이 그대로 입력
array = input().split()


# 16. map(int, ) 와 int()의 차이
# map은 두개이상의 데이터가 들어올시 바로 바꿔주고 int바로쓰면 오류


# 17. 입력데이터가 많은 경우
# input() 대신에 사용
import sys
input_data = sys.stdin.readline().rstrip()
print(input_data)


# 18. 리스트로 바로바로 입력됨.
input = sys.stdin.readline
print(input().split())


# 19. 무한대
INF = int(1e9)


# 20. 힙큐 사용
import heapq
q = []
heapq.heappush(q, (1, 2))
# while q: # 큐가 비어있을 때 까지
    # dist, now = heapq.heappop(q) # 꺼냄


# 21. str은 문자열 변경 접근 안됨
# 리스트로 변경해서 진행
a = list("1")


# 22. 문자가 알파벳인지 확인
a = "a"
a.isalpha()


# 23. 절대값
abs(-1)