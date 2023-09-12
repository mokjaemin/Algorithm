


# 럭키 스트레이트


def solution(input):
    result1 = 0
    result2 = 0
    mid_index = int(len(input)/2)-1
    for i in range(len(input)):
        if i <= mid_index:
            result1 += int(input[i])
            continue
        result2 += int(input[i])
    if result1 == result2:
        print("LUCKY")
    else:
        print("READY")

input1 = "123402"
input2 = "7755"
solution(input1)
solution(input2)

