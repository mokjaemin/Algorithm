

# 감시 피하기

n1 = 5
map1 = [
    ['x', 'S', 'x', 'x', 'T'],
    ['T', 'x', 'S', 'x', 'x'],
    ['x', 'x', 'x', 'x', 'x'],
    ['x', 'T', 'x', 'x', 'x'],
    ['x', 'x', 'T', 'x', 'x']
]
n2 = 4
map2 = [
    ['S', 'S', 'S', 'T'],
    ['x', 'x', 'x', 'x'],
    ['x', 'x', 'x', 'x'],
    ['T', 'T', 'T', 'x']
]

# x의 위치 파악
x_list = []
for i in range(n1):
    for j in range(n1):
        if map1[i][j] == 'x':
            x_list.append([i, j])

# x의 위치 중 3개를 골라 조합
from itertools import combinations
obstacles = list(combinations(x_list, 3))

# 선생님께 걸리는지 체크
def check(map_):
    for i in range(len(map_)):
        for j in range(len(map_)):
            if map_[i][j] == 'T':
                if i-1 >= 0:
                    if map_[i-1][j] == 'x':
                        c = i-1
                        while c >= 0:
                            c -= 1
                            if map_[c][j] == 'S':
                                return False
                            elif map_[c][j] == 'O':
                                break
                    elif map_[i-1][j] == 'S':
                        return False
                if i+1 < len(map_):
                    if map_[i+1][j] == 'x':
                        c = i+1
                        while c < len(map_)-1:
                            c += 1
                            if map_[c][j] == 'S':
                                return False
                            elif map_[c][j] == 'O':
                                break
                    elif map_[i+1][j] == 'S':
                        return False
                if j-1 >= 0:        
                    if map_[i][j-1] == 'x':
                        c = j-1
                        while c >= 0:
                            c -= 1
                            if map_[i][c] == 'S':
                                return False
                            elif map_[i][c] == 'O':
                                break
                    elif map_[i][j-1] == 'S':
                        return False
                if j+1 < len(map_):
                    if map_[i][j+1] == 'x':
                        c = j+1
                        while c < len(map_)-1:
                            c += 1
                            if map_[i][c] == 'S':
                                return False
                            elif map_[i][c] == 'O':
                                break
                    elif map_[i][j+1] == 'S':
                        return False
    return True

# 장애물 놓기
result = 0

# 맵 복사본
map_ = map1

for obstacle in obstacles:

    # 장애물 설치
    for a in obstacle:
        map_[a[0]][a[1]] = 'O'

    # 선생님께 걸리는지 검사
    if check(map_):
        for i in map_:
            print(i)
        result = 1
        break
    
    # 장애물 제거
    for a in obstacle:
        map_[a[0]][a[1]] = 'x'
    
    
if result == 1:
    print("YES")
else:
    print("NO")