


# 자물쇠와 열쇠

# 90도 회전 함수
def rotate_a_matrix_by_90_degree(a): # 리스트를 입력으로
    n = len(a) # 행 길이 계산
    m = len(a[0]) # 열 길이 계산
    result = [[0]*n for _ in range(m)] # 해당 리스트의 행, 열 크기만 큼 0행렬 생성
    for i in range(n):
        for j in range(m):
            result[j][n-i-1] = a[i][j]
    return result

# 키와 자물쇠를 다 더한 값이 1인지 확인
def check(new_lock):
    # 확장한 판을 실제크기로 재조정 후 확인
    lock_length = len(new_lock)//3
    for i in range(lock_length, lock_length*2):
        for j in range(lock_length, lock_length*2):
            if new_lock[i][j] != 1:
                return False
    return True


def soultuon(key, lock): # 키와 자물쇠를 인자로 받는다
    n = len(lock) # 자물쇠의 크기
    m = len(key) # 키의 크기
    new_lock = [[0]*(n*3) for _ in range(n*3)] # 자물쇠의 크기를 기존의 3배로 변환
    # 새로만든 자뭃쇠 판의 가운데에 실제 자물쇠 넣기
    for i in range(n):
        for j in range(n):
            new_lock[i+n][j+n] = lock[i][j]
    
    for rotation in range(4): # 4가지 방향에 대해서 확인
        key = rotate_a_matrix_by_90_degree(key) # 키를 90도 회전
        for x in range(n*2):
            for y in range(n*2):
                for i in range(m):
                    for j in range(m):
                        new_lock[x+i][y+j] += key[i][j]
                if check(new_lock) == True:
                    return True
                for i in range(m):
                    for j in range(m):
                        new_lock[x+i][y+j] -= key[i][j]
    return False