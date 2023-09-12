
# 괄호 변환

def test1(array):
    count = 0
    for i in array:
        if i == "(":
            count += 1
        else:
            count -= 1
        if count < 0:
            return False
    return True

def solution(array):
    if len(array) == 0:
        return ""
    count1,count2 = 0, 0
    for i in range(len(array)):
        if array[i] == "(":
            count1 += 1
        else:
            count2 += 1
        if count1 == count2:
            u = array[0:i+1]
            if i+1 >= len(array):
                v = ""
                break
            v = array[i+1:]
            break
    if test1(u):
        v = solution(v)
    else:
        mid = ""
        for i in range(1, len(u)-1):
            if u[i] == "(":
                mid += ")"
            else:
                mid += "("
        result = "(" + solution(v) + ")" + mid
        return result
    return u+v


array = "()))((()"
print(solution(array))