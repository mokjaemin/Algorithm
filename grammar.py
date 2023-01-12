# 기본 문법 정리

# 1. 나눗셈 관련
print(5//3)
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


# continue
# for 안에 continue는 for문을 나감
for i in range(4):
    if(i == 1):
        continue
    print(i)