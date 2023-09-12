



# 가사검색

from bisect import bisect_left, bisect_right


def count_by_sort(array, left_value, right_value):
    left_index = bisect_left(array, left_value)
    right_index = bisect_right(array, right_value)
    return right_index - left_index

w_correct = [[] for _ in range(10001)]
w_reverse = [[] for _ in range(10001)]

def solution(words, queries):
    
    for i in range(len(words)):
        w_correct[len(words[i])].append(words[i])
        w_reverse[len(words[i])].append(words[i][::-1])

    for i in range(10001):
        w_correct[i].sort()
        w_reverse[i].sort()
        
    final_result = []
    for query in queries:
        q_length = len(query)
        if query[0] != "?":
            result = count_by_sort(w_correct[q_length], query.replace('?', 'a'), query.replace('?', 'z'))
        else:
            result = count_by_sort(w_reverse[q_length], query[::-1].replace('?', 'a'), query[::-1].replace('?', 'z'))
        final_result.append(result)
    return final_result


words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]
print(solution(words, queries))