


#  블록 이동하기

from collections import deque
n = 5
board = [
    [0, 0, 0, 1, 1],
    [0, 0, 0, 1, 0],
    [0, 1, 0, 1, 1],
    [1, 1, 0, 0, 1],
    [0, 0, 0, 0, 0]
]
direction = 0 # 0-가로, 1-세로
start = [[0, 0], [0, 1], direction]
end = [n-1, n-1]
dx = [-1, 0, 1, 0] # 북, 서, 남, 동
dy = [0, -1, 0, 1]
queue = deque()
queue.append(start)


# check Function - if they can turn or not
# i - 북, 서, 남, 동
def check(x, y, direction, i):
    if direction == 0:
        if i == 0:
            if x-1 >= 0:
                if board[x-1][y] == 0:
                    return True
        elif i == 1:
            return True
        elif i == 2:
            if x+1 <= n-1:
                if board[x+1][y] == 0:
                    return True
        else:
            return True
    else:
        if i == 0:
            return True
        elif i == 1:
            if y-1 >= 0:
                if board[x][y-1] == 0:
                    return True
        elif i == 2:
            return True
        else:
            if y+1 <= n-1:
                if board[x][y+1] == 0:
                    return True
    return False





# bfs - Robot moving Function
def bfs(x1, y1, x2, y2, direction):
    for i in range(4):
        if direction == 0:
            if i == 0 or i == 2:
                mx1 = x1+dx[i]
                my1 = y1+dy[i]
                mx2 = x2+dx[i]
                my2 = y2+dy[i]
                if 0 <= mx1 <= n-1 and 0 <= mx2 <= n-1 and 0 <= my1 <= n-1 and 0 <= my1 <= n-1:
                    if board[mx1][my1] == 0 and board[mx2][my2] == 0:
                        checklist1 = [[mx1, my1], [mx2, my2]]
                        checklist2 = [[mx2, my2], [mx1, my1]]
                        available = True
                        for i in visitcheck:
                            if i == checklist1:
                                available = False
                            elif i == checklist2:
                                available = False
                        if available:
                            visitcheck.append(checklist1)
                            visitcheck.append(checklist2)
                            queue.append([[mx1, my1], [mx2, my2], direction])
        else:
            if i == 1 or i == 3:
                mx1 = x1+dx[i]
                my1 = y1+dy[i]
                mx2 = x2+dx[i]
                my2 = y2+dy[i]
                if 0 <= mx1 <= n-1 and 0 <= mx2 <= n-1 and 0 <= my1 <= n-1 and 0 <= my1 <= n-1:
                    if board[mx1][my1] == 0 and board[mx2][my2] == 0:
                        checklist1 = [[mx1, my1], [mx2, my2]]
                        checklist2 = [[mx2, my2], [mx1, my1]]
                        available = True
                        for i in visitcheck:
                            if i == checklist1:
                                available = False
                            elif i == checklist2:
                                available = False
                        if available:
                            visitcheck.append(checklist1)
                            visitcheck.append(checklist2)
                            queue.append([[mx1, my1], [mx2, my2], direction])
    for i in range(4):
        nx1 = x1 + dx[i]
        ny1 = y1 + dy[i]
        nx2 = x2 + dx[i]
        ny2 = y2 + dy[i]
        if 0 <= nx1 <= n-1 and 0 <= nx2 <= n-1 and 0 <= ny1 <= n-1 and 0 <= ny1 <= n-1:
            if board[nx1][ny1] == 0:
                checklist1 = [[x1, y1], [nx1, ny1]]
                checklist2 = [[nx1, ny1], [x1, y1]]
                available = True
                for i in visitcheck:
                    if i == checklist1:
                        available = False
                    elif i == checklist2:
                        available = False
                if available:
                    visitcheck.append(checklist1)
                    visitcheck.append(checklist2)
                    if check(x2, y2, direction, i):
                        board[nx1][ny1] = board[x1][y1] + 1
                        if direction == 0 and (i == 0 or i == 2):
                            direction = 1
                        elif direction == 1 and (i == 1 or i == 3):
                            direction = 0
                        queue.append([[x1, y1], [nx1, ny1], direction])
                    else:
                        print("cant move")
                else:
                    print("cant move")
            if board[nx2][ny2] == 0:
                checklist1 = [[x2, y2], [nx2, ny2]]
                checklist2 = [[nx2, ny2], [x2, y2]]
                available = True
                for i in visitcheck:
                    if i == checklist1:
                        available = False
                    elif i == checklist2:
                        available = False
                if available:
                    visitcheck.append(checklist1)
                    visitcheck.append(checklist2)
                    if check(x1, y1, direction, i):
                        board[nx2][ny2] = board[x2][y2] + 1
                        if direction == 0 and (i == 0 or i == 2):
                            direction = 1
                        elif direction == 1 and (i == 1 or i == 3):
                            direction = 0
                        queue.append([[x2, y2], [nx2, ny2], direction])
                    else:
                        print("cant move")
                else:
                    print("cant move")



# Main Funtion
final = False
visitcheck = []
while queue:
    now = queue.popleft()

    x1, y1 = now[0] # 첫번째 인덱스
    x2, y2 = now[1] # 두번째 인덱스
    direction = now[2] # 현재 방향 0-가로, 1-세로
    visitcheck.append([[x1, y1], [x2, y2]])
    visitcheck.append([[x2, y2], [x1, y1]])

    if now[0] == end or now[1] == end:
        print("result : ", board[n-1][n-1])
        final = True
        break

    bfs(x1, y1, x2, y2, direction)
    print(queue)
    print("direction: ", direction)
    print(x1, y1, x2, y2)
    for i in board:
        print(i)
    print(" ")

if not final:
    print("Can't go to destination")