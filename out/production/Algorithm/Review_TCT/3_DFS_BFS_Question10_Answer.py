

# 블록 이동하기

from collections import deque
n = 5
board = [
    [0, 0, 0, 1, 1],
    [0, 0, 0, 1, 0],
    [0, 1, 0, 1, 1],
    [1, 1, 0, 0, 1],
    [0, 0, 0, 0, 0]
]
start = {(1, 1), (1, 2)}
end = (n, n)


# 다음으로 이동 가능한 위치 리스트 구하는 함수
def get_next_move(now, new_board, visited):
    now = list(now)
    x1, y1, x2, y2 = now[0][0], now[0][1], now[1][0], now[1][1]
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    next_list = []
    # 회전 없이 상하좌우 이동
    for i in range(4):
        nx1 = x1 + dx[i]
        ny1 = y1 + dy[i]
        nx2 = x2 + dx[i]
        ny2 = y2 + dy[i]
        if new_board[nx1][ny1] == 0 and new_board[nx2][ny2] == 0:
            if {(nx1, ny1), (nx2, ny2)} not in visited:
                next_list.append({(nx1, ny1), (nx2, ny2)})
    # 가로 일때 회전 이동
    if x1 == x2:
        for i in [-1, 1]:
            if new_board[x1 + i][y1] == 0 and new_board[x2+i][y2] == 0:
                if {(x1+i, y1), (x1, y1)} not in visited:
                    next_list.append({(x1+i, y1), (x1, y1)})
                if {(x2+i, y2), (x2, y2)} not in visited:
                    next_list.append({(x2+i, y2), (x2, y2)})
    # 세로 일때 회전 이동
    if y1 == y2:
        for i in [-1, 1]:
            if new_board[x1][y1+i] == 0 and new_board[x2][y2+i] == 0:
                if {(x1, y1+i), (x1, y1)} not in visited:
                    next_list.append({(x1, y1+i), (x1, y1)})
                if {(x2, y2+i), (x2, y2)} not in visited:
                    next_list.append({(x2, y2+i), (x2, y2)})
    return next_list



# 메인
def main(board, start, end):
    # 그래프 확장, 이를 통해 그래프 범위 벗어나는 여부 확인 필요가 없어짐
    n = len(board)
    new_board = [[1]*(n+2) for i in range(n+2)]
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j] == 0:
                new_board[i+1][j+1] = 0

    cost = 0
    queue = deque()
    queue.append((start, cost))
    visited = []

    while queue:
        now, cost = queue.popleft()
        for i in now:
            if i == end:
                return cost
        visited.append(now)
        nextList = get_next_move(now, new_board, visited)
        cost += 1
        for i in nextList:
            queue.append((i, cost))
    
    return 0
            

    

cost = main(board, start, end)
if cost:
    print("Available")
    print("cost : ", cost)
else:
    print("Unavailable")