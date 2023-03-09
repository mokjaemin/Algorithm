


# 가사 검색

# 그냥 생각나는 대로 코딩

words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]
# 각각 쿼리의 길이
queries_length = [len(i) for i in queries]
# 물은표 없는 곳의 위치
question_pos = [[] for i in range(len(queries))]
for i in range(len(queries)):
    for j in range(len(queries[i])):
        if queries[i][j] != "?":
            question_pos[i].append(j)

# 최종 결과
final = []

for i in range(len(queries)): # 쿼리 마다
    result = 0 # 쿼리마다 해당되는 단어수 초기화
    for word in words: # 단어 마다
        if len(word) == queries_length[i]: # 길이가 같은지 확인
            count = 0
            for j in question_pos[i]: # 물음표가 아닌 위치마다
                if word[j] == queries[i][j]: # 같은지 확인
                    count += 1
            if count == len(question_pos[i]):
                result += 1
    final.append(result)
# print(final)
            


# 답안

# from bisect import bisect_left, bisect_right

# def count_by_range(a, left_value, right_value):
#     # a - 단어들
#     print(a)
#     print(left_value)
#     print(right_value)
#     right_index = bisect_right(a, right_value)
#     left_index = bisect_left(a, left_value)
#     print(left_index, right_index)
#     return right_index - left_index

# # 단어의 최대 길이는 10000
# array = [[] for _ in range(10001)]
# # 역을 구하는 이유는 ?로 시작을 안할경우를 대비해 역으로 만들려고
# reversed_array = [[] for _ in range(10001)]


# def solution(words, queries):
#     answer = [] # 결과 변수 초기화
#     for word in words: # 모든 단어들을 길이마다 분리
#         array[len(word)].append(word)
#         reversed_array[len(word)].append(word[::-1])

#     for i in range(10001): # 모든 길이들에 대해서 단어들을 오름차순으로 정렬
#         array[i].sort()
#         reversed_array[i].sort()

#     for q in queries: # 모든 쿼리 마다
#         if q[0] != "?": # 쿼리의 첫번째가 ?가 아니라면
#             # query의 길이의 맞는 단어들과 물음표를 a로 대체한 변수와 z로 대첼한 변수 전달
#             res = count_by_range(array[len(q)], q.replace('?', 'a'), q.replace('?', 'z'))
#         else:
#             res = count_by_range(reversed_array[len(q)], q[::-1].replace('?', 'a'), q[::-1].replace('?', 'z'))
#         answer.append(res)
#     return answer

# words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
# queries = ["fro??", "????o", "fr???", "fro???", "pro?"]
# answer = solution(words, queries)
# print(answer)




# 재작성
from bisect import bisect_left, bisect_right
# bisec 함수 : 정렬된 배열안에서 해당 값이 들어가야할 위치를 반환
def count_by_range(array, left_value, right_value):
    left_index = bisect_left(array, left_value)
    right_index = bisect_right(array, right_value)
    return right_index - left_index


# 역을 만드는 이유 : 정렬된 배열안에 순서를 찾는 원리를 사용중인데
# ?로 시작되는 문자들은 순서 찾는 데에 지장을 줌
# 예를 들어 "???o" 를 "aaao" 변경시 순서를 이용한 위치 찾기를 이용할 수 없음
array = [[] for _ in range(10001)]
reversed_array = [[] for _ in range(10001)]


def solution(words, queries):
    answer = []
    for word in words:
        array[len(word)].append(word)
        reversed_array[len(word)].append(word[::-1])
    for i in range(10001):
        array[i].sort()
        reversed_array[i].sort()
    
    for query in queries:
        if query[0] != '?':
            result = count_by_range(array[len(query)], query.replace('?', 'a'), query.replace('?', 'z'))
            answer.append(result)
        else:
            result = count_by_range(reversed_array[len(query)], query[::-1].replace('?', 'a'), query[::-1].replace('?', 'z'))
            answer.append(result)
    return answer




words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]
answer = solution(words, queries)
print(answer)