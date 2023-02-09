

# 기둥과 보 설치

# n = int(input("입력 : "))
n = 5
# count = int(input("입력 : "))
frame_map = [[0]*(n+1) for i in range(n+1)]
frames = [[0, 0, 0, 1], [2, 0, 0, 1], [4, 0, 0, 1], [0, 1, 1, 1], [1, 1, 1, 1], [2, 1, 1, 1], [3, 1, 1, 1], [2, 0, 0, 0], [1, 1, 1, 0], [2, 2, 0, 1]]
# for i in range(count):
#     frames.append(list(map(int, input("입력 : ").split())))
for frame in frames:
    if frame[3] == 0:
        if frame[2] == 0:
            if frame_map[frame[0]+1][frame[1]+1] != 0 and frame_map[frame[0]-1][frame[1]+1] != 0:
                frame_map[frame[0]][frame[1]] = 0
                print("기둥 삭제")
        else:
            if frame_map[frame[0]+1][frame[1]-1] != 0:
                frame_map[frame[0]+1][frame[1]] = 0
                print("보 삭제")
    else:
        if frame[2] == 0:
            if frame[1] == 0 or frame_map[frame[0]][frame[1]] == 1:
                frame_map[frame[0]][frame[1]] = 1
                frame_map[frame[0]][frame[1]+1] = 1
                print("기둥 설치")
        else:
            if frame_map[frame[0]][frame[1]] == 1 and frame[1] != 0:
                frame_map[frame[0]][frame[1]] = 1
                frame_map[frame[0]+1][frame[1]] = 1
                print(frame_map[2][1])
                print(frame_map[3][1])
                print("보 설치")
    print(frame_map)