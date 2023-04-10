


# 연구소

from itertools import combinations
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def virus(x, y, test):
    for k in range(4):
        now_x = x + dx[k]
        now_y = y + dy[k]
        if now_x < 0 or now_x >= n or now_y < 0 or now_y >= m:
            continue
        if test[now_x][now_y] == 0:
            test[now_x][now_y] = 3
            virus(now_x, now_y, test)

def solution(array, n, m):

    # 벽을 놓기 위한 0의 위치 구하기
    walls = []
    for i in range(n):
        for j in range(m):
            if array[i][j] == 0:
                walls.append([i, j])
    
    # 빈곳에 벽을 3개 놓는 모든 조합
    com_walls = list(combinations(walls, 3))

    # 경우의 수 처리
    result = []
    index = 0
    for com_wall in com_walls:

        # 테스트 맵 항상 초기화
        test = [[] for _ in range(n)]
        for i in range(n):
            for j in range(m):
                test[i].append(array[i][j])
        for wall in com_wall:
            test[wall[0]][wall[1]] = 1        

        # 감염 처리
        for i in range(n):
            for j in range(m):
                if array[i][j] == 2:
                    virus(i, j, test)


        # 감염안된 부분 계산
        count = 0
        for i in range(n):
            for j in range(m):
                if test[i][j] == 0:
                    count += 1
        result.append(count)

    print(max(result))
        



n, m = map(int, input().split())
array = []
for _ in range(n):
    array.append(list(map(int, input().split())))

solution(array, n, m)

