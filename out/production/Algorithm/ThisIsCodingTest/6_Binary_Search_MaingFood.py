



# 실전문제 3 - 떡볶이 떡 만들기
# 입력 1 - 떡의 개수 n , 요청한 떡의 길이 m 
# 입력 2 - 떡의 개별 높이
# 출력 - 떡의 개별 높이에서 지정한 절단기 높이만큼 자르고 나머지가 요청한 떡의 길이 m이 되게하는
# 최대 절단기 높이를 구한다.


# 나의 답변 1 - 순차적 탐색을 사용한듯
# n, m = map(int, input("입력 : ").split())
# lst = []
# lst.append(list(map(int, input("입력 : ").split())))
# for i in range(max(lst[0]), 0, -1):
#     result = 0
#     for j in range(n):
#         length = 0
#         length += lst[0][j] - i
#         if(length < 0):
#             length = 0
#         result += length
#     print("result : ", result, " minus : ", i)
#     if (result == m):
#         print(i)
#         break

# 나의 답변 2 - 이진탐색으로 구현해보자
# n, m = map(int, input("입력 : ").split())
# lst = []
# lst.append(list(map(int, input("입력 : ").split())))

# def binary_find(array, start, end, target):
#     if start > end:
#         return None
#     mid = (end+start)//2
#     result = 0
#     for i in range(n):
#         if array[0][i] - mid > 0:
#             result += array[0][i] - mid
#     print("cut : ", mid, " result : ", result)
#     if result == target:
#         return mid
#     elif result > target:
#         return binary_find(array, mid+1, end, target)
#     else:
#         return binary_find(array, start, mid-1, target)


# start = 0
# end = max(lst[0])
# print(lst)
# result = binary_find(lst, start, end, m)
# print(result)


# 답안
# 아이디어 
# - 범위 내에서 조건을 만족하는 가장 큰 값을 찾으라는 최적화 문제(파라메트릭 서치 문제)이면 이진탐색
# - 또한 입력가능한 범위가 굉장히 큰 수이면 무조건 이진탐색 생각
# - 파라메트릭 서치 문제에서는 반복문 구현이 재귀적 구현보다 간결

n, m = map(int, input("입력 : ").split())
lst = []
lst.append(list(map(int, input("입력 : ").split())))
start = 0
end = max(lst[0])

result = 0

while start <= end:
    total = 0
    mid = (start + end) // 2
    for x in lst[0]:
        if x > mid:
            total += x-mid
    if total > m :
        start = mid + 1
    elif total < m :
        end = mid - 1
    else:
        print(mid)
        break