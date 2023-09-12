


# 자물쇠와 열쇠


# def rotation(array):
#     x_length = len(array)
#     y_length = len(array[0])
#     new_array = [[0]*x_length for i in range(y_length)]
#     for i in range(x_length):
#         for j in range(y_length):
#             new_array[j][x_length-i-1] = array[i][j]
#     return new_array

# def check(new_lcok):
#     lock_length = len(new_lcok)//3
#     for x in range(lock_length, lock_length*2):
#         for y in range(lock_length, lock_length*2):
#             if new_lcok[x][y] != 1:
#                 return False
#     return True



# def solution(key, lock):
#     m = len(key)
#     n = len(lock)

#     new_lock = [[0]*(n*3) for _ in range(len(lock[0])*3)]

#     for i in range(n):
#         for j in range(n):
#             new_lock[i+n][j+n] = lock[i][j]

#     for change in range(4):
#         key = rotation(key)
#         for x in range(n*2):
#             for y in range(n*2):
#                 for i in range(m):
#                     for j in range(m):
#                         new_lock[x+i][y+j] += key[i][j]
                
#                 if check(new_lock) == True:
#                     return True
#                 for i in range(m):
#                     for j in range(m):
#                         new_lock[x+i][y+i] -= key[i][j]
    
#     return False



def rotataion(array):
    x_length = len(array)
    y_length = len(array[0])
    new_array = [[0]*y_length for _ in range(x_length)]
    for i in range(x_length):
        for j in range(y_length):
            new_array[j][x_length-i-1] = array[i][j]

def check(array):
    n = len(array)//3
    for i in range(n, n*2):
        for j in range(n, n*2):
            if array[i][j] != 1:
                return False
    return True


def solution(lock, key):
    n = len(lock)
    m = len(key)
    new_lock = [[0]*(len(lock[0])*3) for _ in range(n*3)]

    for i in range(n):
        for j in range(len(lock[0])):
            new_lock[i+3][j+3] = lock[i][j]

    for x in range(2*n):
        for y in range(2*n):
            for i in range(m):
                for j in range(m):
                    new_lock[x+i][y+j] += key[i][j]
            
            if check(new_lock):
                return True
            
            for a in range(m):
                for b in range(m):
                    new_lock[x+i][y+j] -= key[i][j]

    return False

