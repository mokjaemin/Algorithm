
# DFS, BFS 개념 정리
# 탐색의 알고리즘

# 알아야 할 개념
# 1. 탐색
# 많은 양의 데이터 중에서 원하는 데이터를 찾는 과정

# 2. 자료구조
# 데이터를 표현하고 관리하고 처리하기 위한 구조
# 예시 - list, deque, queue 등
# 삽입(Push) - 데이터를 삽입한다.
# 삭제(Pop) - 데이터를 삭제한다.

# (+) 오버플로, 언더플로
# 오버플로 - 특정한 자료구조가 수용할 수 있는 데이터의 크기를 이미 가득 찬 상태에서 삽입연산을 수행할때 발생
# 언더플로 - 특정한 자료구조에 데이터가 전혀 들어 있지 않은 상태에서 삭제연산을 수행하면 발생

# 3. 스택
# 박스를 생각, 선입후출 구조 또는 후입 선출 구조
# 먼저 들어가면 나중에 나오고 나중에 들어가면 먼저 나온다.
# ex)
stack = []
stack.append(5)
stack.append(2)
stack.append(3)
stack.append(7)
stack.pop() # 마지막인 7 삭제
stack.append(1)
stack.append(4)
stack.pop() # 마지막인 4 삭제
# print(stack)
# print(stack[::-1])

# 4. 큐
# 대기줄 생각, 선입선출구조
# 먼저 줄스면 먼저 나감.
# ex)
from collections import deque
queue = deque()

queue.append(5)
queue.append(2)
queue.append(3)
queue.append(7)
queue.popleft() # 맨 앞 삭제
queue.append(1)
queue.append(4)
queue.popleft()

# (+) deque
# - 스택과 큐의 장점을 모두 채택
# - 데이터를 넣고 빼는 속도가 리스트 자료형에 비해 효율적
# - queue 라이브러리를 이용하는 것보다 간단.
# - list(deque 변수) 하면 리스트로 자료형이 변환된다.

# 5. 재귀 함수
# 자기 자신을 다시 호출하는 함수
# 종료 조건을 항상 써주자
# 스택 자료구조를 이용 - 가장 마지막에 호출한 함수가 먼저 수행을 끝내야 그 앞의 함수 호출이 종료되기 때문에
# 컴퓨터 구조의 측면에서 보면 연속해서 호출되는 함수는 메인 메모리의 스택 공간에 적재
# ex1)
def recursive_function():
    print("재귀함수를 호출합니다.")
    recursive_function()
# ex2) 팩토리얼의 구현을 재귀함수와 for문으로
def factorial(n):
    if n <= 1:
        return 1
    return n*factorial(n-1)
print(factorial(5)) # 5*4*3*2*1
result = 1
for i in range(2, 6):
    result *= i
print(result)
# 재귀함수를 사용했을 때, 반복문보다 장점
# 1. 코드가 더 간결 - 재귀 함수가 수학의 점화식(재귀식)을 그대로 소스코드로 옮겼기 때문에

# (+) 점화식
# 특정한 함수를 자신보다 더 작은 변수에 대한 함수와의 관계로 표현한 것
# ex)
# 1. n이 0 혹은 1 일때 - factorial(n) = 1
# 2. n이 1 보다 클 때 - factorial(n) = n*factorial(n-1)
# 점화식과 위의 코드가 비슷하다는 것을 알 수 있다.
