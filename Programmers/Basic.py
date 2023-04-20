


# 1. 문자열 대소문자 판단
i = 'a'
print(i.isalpha())
print(i.isupper())
print(i.islower())
print(i.upper())
print(i.lower())


# 2. 리스트를 문자열로
check = ['A', 'B']
answer = ''.join(str(s) for s in check)

# 3. 특정 인덱스에 삽입, 인덱스 0에 0삽입
check = [1, 2, 3, 4, 5]
check.insert(0, 0)