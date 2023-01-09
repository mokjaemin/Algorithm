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
