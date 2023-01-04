
# 실전문제 2 - 게임 개발

# 맵 : NxM (3 =< N,M =< 50)
# 바다(1)와 육지(0)가 있는데 바다로는 갈 수 없음
# 메뉴열
# 1. 현재 위치에서 현재 방향을 기준으로 왼쪽방향(반시계 방향으로 90도 회전한 방향)부터 차례대로 갈곳을 설정
# 2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 후 한칸 전진한다.
# 가보지 않은 칸이 없다면 회전 후 다시 1단계로 돌아간다.
# 3. 만약 네 방향 모두 가본 칸이거나 바다로 되어있는 칸이라면, 바라보는 방향을 유지한채로 한칸 뒤로 가고
# 1단계로 돌아간다. 단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
# 결론
# 캐릭터가 이동을 마친 후 방문한 칸의 수를 출력하는 프로그램

import numpy as np

map_input = input("입력 : ").split(" ")
pos_input = input("입력 : ").split(" ")

map_x = int(map_input[0])
map_y = int(map_input[1])

pos_x = int(pos_input[0])
pos_y = int(pos_input[1])
pos_d = int(pos_input[2])

map = []

for i in range(0, map_x):
    map.append(input("입력 : ").split(" "))
map = np.array(map)
route = []
path = 1

# 북 - 0, 서 - 3, 남 - 2, 동 - 1 
while(1):
    for i in range(0, 4):
        if(pos_d == 0):
            pos_d = 3
            if(map[pos_x, pos_y-1] == "1"):
                route.append("x")
            elif(map[pos_x, pos_y-1] == "0"):
                route.append("o")
                map[pos_x, pos_y] = 2
                pos_y = pos_y - 1
                path += 1
            elif(map[pos_x, pos_y-1] == "2"):
                route.append("x")

        elif(pos_d == 1):
            pos_d = 0
            if(map[pos_x-1, pos_y] == "1"):
                route.append("x")
            elif(map[pos_x-1, pos_y] == "0"):
                route.append("o")
                map[pos_x, pos_y] = 2
                pos_x = pos_x - 1
                path += 1
            elif(map[pos_x-1, pos_y] == "2"):
                route.append("x")

        elif(pos_d == 2):
            pos_d = 1
            if(map[pos_x, pos_y+1] == "1"):
                route.append("x")
            elif(map[pos_x, pos_y+1] == "0"):
                route.append("o")
                map[pos_x, pos_y] = 2
                pos_y = pos_y + 1
                path += 1
            elif(map[pos_x, pos_y+1] == "2"):
                route.append("x")

        elif(pos_d == 3):
            pos_d = 2
            if(map[pos_x+1, pos_y] == "1"):
                route.append("x")
            elif(map[pos_x+1, pos_y] == "0"):
                route.append("o")
                map[pos_x, pos_y] = 2
                pos_x = pos_x + 1
                path += 1
            elif(map[pos_x+1, pos_y] == "2"):
                route.append("x")
    if(len(route) == 4):
        if(route == ["x", "x", "x", "x"]):
            print(path)
            break
        else:
            route = []