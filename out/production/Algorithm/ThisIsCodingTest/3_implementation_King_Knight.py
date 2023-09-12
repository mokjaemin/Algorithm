

# 실전문제 1 - 왕실의 나이트
# 8x8 크기의 판에서 나이트는 L자형 이동만 가능하고 판에서 나갈 수 없음
# 이동 경우의 수
# - 수평으로 두칸 이동 후, 수직으로 한칸 이동
# - 수직으로 두칸 이동 후, 수평으로 한칸 이동
# 행은 1~8로 표현, 열은 a~h로 표현.
# 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 설계하시오.

# 나의 답안
# pos = input("위치 : ")
# x = pos[0]
# y = int(pos[1])
# count = 0
# if(x == "a"):
#     x = 1
# if(x == "b"):
#     x = 2
# if(x == "c"):
#     x = 3
# if(x == "d"):
#     x = 4
# if(x == "e"):
#     x = 5
# if(x == "f"):
#     x = 6
# if(x == "g"):
#     x = 7
# if(x == "h"):
#     x = 8

# if((x+2)<9):
#     if((y+1)<9):
#         count += 1
#     if((y-1)>0):
#         count += 1
# if((x-2)>0):
#     if((y+1)<9):
#         count += 1
#     if((y-1)>0):
#         count += 1
# if((y+2)<9):
#     if((x+1)<9):
#         count += 1
#     if((x-1)>0):
#         count += 1
# if((y-2)>0):
#     if((x+1)<9):
#         count += 1
#     if((x-1)>0):
#         count += 1

# print(count)

# 답안지
# 아이디어
# 1. 스텝 만들기
# 2. 영어 문자, 기준에 맞는 숫자 인덱스로 변경
# pos = input("위치 : ")
# row = int(pos[1])
# column = int(ord(pos[0]) - int(ord('a'))) + 1
# count = 0
# steps = [(-2, -1), (-2, 1), (2, -1), (2, 1), (1, -2), (1, 2), (-1, -2), (-1, 2)]
# for step in steps:
#     next_row = step[0]
#     next_column = step[1]
#     if(next_row>0 and next_row<9 and next_column>0 and next_column<9):
#         count += 1
# print(count)