
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
# 북, 동, 남, 서 (0, 1, 2, 3)

# golbal 변수 만드는 아이디어
# 방향 만들기
# 헷갈리는 논리를 깔끔하게 정리하고 로직 구성하는게 중요할 듯


# 답안
n, m = map(int, input("입력 : ").split()) # 맵 크기 입력
d = [[0]*m for _ in range(n)] # 가본 맵 만들기

x, y, direction = map(int, input("입력 : ").split()) # 캐릭터의 위치, 방향
d[x][y] = 1 # 초기 위치 방문 설정

array = []
for i in range(n):
    array.append(list(map(int, input("입력 : ").split()))) # 전체 맵 설정

dx = [-1, 0, 1, 0] # 북, 동, 남, 서
dy = [0, 1, 0, -1]

# 왼쪽으로 회전
def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3


# 시뮬레이션 시작
count = 1 # 이미 한번 밟았으니
turn_time = 0

while(1):
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    if d[nx][ny] == 0 and array[nx][ny] == 0:
        d[nx][ny] = 1
        x = nx
        y = ny
        count += 1
        turn_time = 0
        continue
    else:
        turn_time += 1
    
    # 네 방향 모두 갈 수 없는 경우
    if turn_time == 4:
        print('x')
        nx = x - dx[direction]
        nx = y - dy[direction]
        # 뒤로 갈 수 있다면 이동하기
        if array[nx][ny] == 0:
            x = nx
            y = ny
        else:
            break
        turn_time = 0

print(count)




