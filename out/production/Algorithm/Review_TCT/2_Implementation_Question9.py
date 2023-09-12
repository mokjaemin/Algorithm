


# 외벽 점검

from itertools import permutations

def solution(n, weak, dist):
    length = len(weak) # 취약점의 길이
    for i in range(length): # 원형 취약점을 일자로 만들기
        weak.append(weak[i] + n)
    answer = len(dist) + 1 # 모든 친구를 사용한 경우가 이 문제의 최대값
    # 0부터 length-1 까지의 인덱스를 시작점으로 설정
    for start in range(length):
        # 친구를 나열하는 모든 경우의 수 각각에 대하여 확인
        for friends in list(permutations(dist, len(dist))):
            count = 1 # 투입할 친구의 수
            position = weak[start] + friends[count-1] # end 지점
            for index in range(start, start+length):
                if position < weak[index]: # 해당 친구만으로는 모든 점검이 불가능한 경우
                    count += 1 # 새로운 친구 투입
                    if count > len(dist): # 친구수 초과시 멈춤
                        break
                    position = weak[index] + friends[count - 1] # end 지점 다시 설정
            answer = min(answer, count)
        if answer > len(dist):
            return -1
        return answer
    
                
