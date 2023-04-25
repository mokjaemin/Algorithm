



# 해당 값의 인덱스 찾기

def solution(emergency):
    answer = []
    check = sorted(emergency, reverse=True)
    
    for i in emergency:
        answer.append(check.index(i)+1)
    return answer