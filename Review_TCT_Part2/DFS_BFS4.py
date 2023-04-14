


# 연구소

from itertools import combinations
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def virus(x, y, array):
    for k in range(4):
        now_x = x + dx[k]
        now_y = y + dy[k]
        if now_x < 0 or now_x >= n or now_y < 0 or now_y >= m:
            continue
        if array[now_x][now_y] == 0:
            array[now_x][now_y] = 3
            virus(now_x, now_y, array)

def solution(array, n, m, empty_pos):
    
    # 빈곳에 벽을 3개 놓는 모든 조합
    com_walls = list(combinations(empty_pos, 3))

    # 경우의 수 처리
    result = []
    for com_wall in com_walls:

        # 벽 설치
        for wall in com_wall:
            array[wall[0]][wall[1]] = 1        

        # 감염 처리
        for i in range(n):
            for j in range(m):
                if array[i][j] == 2:
                    virus(i, j, array)

        # 감염안된 부분 계산
        count = 0
        for i in range(n):
            for j in range(m):
                if array[i][j] == 0:
                    count += 1
        result.append(count)

        # 벽 삭제
        for i in empty_pos:
            array[i[0]][i[1]] = 0

    print(max(result))
        

n, m = map(int, input().split())
array = []
empty_pos = []
for i in range(n):
    array.append(list(map(int, input().split())))
    for j in range(m):
        if array[i][j] == 0:
            empty_pos.append([i, j])

solution(array, n, m, empty_pos)

