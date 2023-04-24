
def solution(emergency):
    answer = []
    check = sorted(emergency, reverse=True)
    
    for i in emergency:
        answer.append(check.index(i)+1)
    return answer