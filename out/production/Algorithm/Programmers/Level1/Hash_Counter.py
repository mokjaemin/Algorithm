

# 해당 리스트에 어떤 요소가 몇개 있는지 해시(키-값) 만들어 줌.
# 사용시 키를 불러와 값을 찾아 비교

from collections import Counter

def solution(participant, completion):
    answer = ''
    p_dict = Counter(participant)
    c_dict = Counter(completion)
    
    for p_name in p_dict:
        if p_dict[p_name] != c_dict[p_name]:
            answer = p_name

    return answer