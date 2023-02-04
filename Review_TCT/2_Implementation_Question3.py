
# 문자열 압축

# def solution(s):
#     answer = 0
#     return answer

# s = input("입력 : ")
# arr = []
# result = [[] for i in range(len(s)//2+1)]
# for i in range(1, len(s)//2+1):
#     for j in range(0, len(s), 2*i):
#         arr.append((s[j:j+i], s[j+i:2*i+j]))

# for i in range(1, len(s)//2+1):
#     content = ""
#     for k in arr:
#         if len(k[0]) == i:
#             if k[0] == k[1]:
#                 content += ("2" + k[0])
#             else:
#                 if k[1] != '':
#                     content += (k[0] + k[1])
#                 else:
#                     content += k[0]
#     result[i].append(content)

# min_value = 1000
# min_index = 0
# for i in range(len(result)):
#     if i != 0:
#         print(i)
#         print(result[i])
#         print("길이 : ", len(result[i][0]))
#         if len(result[i][0]) < min_value:
#             min_index = i
#             min_value = len(result[i][0])

# print(min_value)



# 답변
# def soulution(s):
#     answer = len(s)
#     for step in range(1, len(s)//2 +1): # 1부터 쭉 나누는 경우 고려
#         compressed = "" # 초기 압축값
#         prev = s[0:step] # 기준
#         count = 1
#         for j in range(step, len(s), step):
#             if prev == s[j:j+step]: # 다음단계가 이전과 같다면
#                 count += 1
#             else: # 다음단계가 이전과는 다름
#                 if count >= 2: # 하지만 카운트는 두번이 넘음
#                     compressed += str(count) + prev 
#                 else:
#                     compressed = prev
#                 # 다시 초기화
#                 prev = s[j:j+step]
#                 count = 1
#         # 남아있는 문자열 처리
#         if count >= 2:
#             compressed += str(count) + prev 
#         else: 
#             compressed = prev
#         answer = min(answer, len(compressed))
#     return answer
        

def solution(s):
    answer = len(s)
    for step in range(1, len(s) // 2 + 1):
        compressed = ""
        prev = s[0:step]
        count = 1
        for j in range(step, len(s), step):
            print(answer)
            print(len(s))
            now = s[j:j+step]
            # print(now)
            if now == prev:
                count += 1
            else:
                if count >= 2:
                    compressed += str(count) + prev
                else:
                    compressed += prev
                prev = now
                count = 1
        if count >= 2:
            compressed += str(count) + prev 
        else: 
            compressed += prev
        answer = min(answer, len(compressed))
    return answer


s = input("입력 : ")
print(solution(s))