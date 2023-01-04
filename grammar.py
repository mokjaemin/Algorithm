# 기본 문법 정리

# 나눗셈 관련
print(5//3)
print(5/3)
print(5%3)

# 해당 문자 포함되었는지
# 타입 맞춰줘야 함
n = "3"
if(n in "33"):
    print("yes")

# 영어 문자열의 아스키 코드 상 순서 받기
# 예를들어, a-1, b-2
column = int(ord("a") - int(ord('a'))) + 1
print(column)

# 리스트를 넘파이로
import numpy as np
list = []
list = np.array(list)