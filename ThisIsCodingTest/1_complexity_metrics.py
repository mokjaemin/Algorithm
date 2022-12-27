
# 1. 복잡도 (Complexity Metrics) 
# 알고리즘의 성능을 나타내는 척도
# 종류 : 시간 복잡도, 공간복잡도

# 시간 복잡도 : 알고리즘을 위해 필요한 연산의 횟수
# 공간 복잡도 : 알고리즘을 위해 필요한 메모리의 양
# (+) 복잡도가 낮을수록 좋은 알고리즘
# (+) 두 복잡도의 관계는 상관관계
# (+) 시간 복잡도를 낮추고 공간복잡도를 늘릴수록 시간을 줄일 수 있다.

# 시간 복잡도 
# 프로그래밍에서 시간복잡도는 해당 시간안에 프로그램 실행 완료됨을 의미.

# 예제 1
# 시간복잡도 : O(N), N은 데이터 수, 반복문 부분이 가장 큰 영향력을 행사함에 따라 시간복잡도 설정
# 코드)
# array = [3, 5, 1, 2, 4]
# summary = 0
# for x in array:
#     summary += x
# print(summary)
# 시간복잡도 O(5) - 5회의 연산을 했으므로

# 예제 2
# 코드)
# a = 5
# b = 7
# print(a+b)
# 시간복잡도 O(1)

# 예제 3
# 코드)
# array = [3, 5, 1, 2, 4]
# for i in array:
#     for j in array:
#         temp = i * j
#         print(temp)
# 시간 복잡도 O(N**2) - 하지만 2중반복문의 시간복잡도가 항상 그런것은 아님.

# 시간 복잡도 표
# 위쪽에 있을수록 더 빠르다
# O(1) : 상수 시간
# O(logN) : 로그 시간
# O(N) : 선형 시간
# O(NlogN) : 로그 선형 시간
# O(N**2) : 이차 시간
# O(N**3) : 삼차 시간
# O(2**n) : 지수 시간
# (+) 일반적으로 다항식에서 시간복잡도는 가장 큰 차수를 가진 항을 시간 복잡도로 설정
#     ex) 3*N**3 + 2*N**2 + 100 -> O(N**3)

# (+) 모두 시간 제한이 1초 일때, N의 범위에 따른 시간복잡도 설정법
# N의 범위가 500인 경우 : O(N***3)
# N의 범위가 2000인 경우 : O(N**2)
# N의 범위가 10,000인 경우 : O(NlogN)
# N의 범위가 10,000,000인 경우 : O(N)



# 공간 복잡도
# 공간 복잡도 또한 빅오 표기법으로 표현
# 메모리 제한은 보통 MB 단위, 128MB ~ 512MB -> 데이터의 개수가 1000만 단위가 넘어가지 않도록 설계를 의미



# 수행시간 측정 소스코드 
# import time
# # 측정 시작
# start_time = time.time()
# # 프로그램
# print("hello")
# # 측정 종료
# end_time = time.time()
# # 수행시간 출력
# print("time : ", end_time - start_time)


# 예제
# 선택 정렬과 기본 정렬 라이브러리의 수행시간 비교
# 선택 정력의 최악 : O(N**2), 기본 정렬 라이브러리의 최악 : O(NlogN)
# 코드)
# from random import randint
# import time

# # 배열에 10,000개의 정수를 삽입
# array = []
# for _ in range(10000):
#     array.append(randint(1, 100))

# # 선택 정렬 프로그램 성능 측정
# start_time = time.time()

# # 선택 정렬 프로그램 소스코드
# for i in range(len(array)):
#     min_index = i # 가장 작은 원소의 인덱스
#     for j in range(i+1, len(array)):
#         if array[min_index] > array[j]:
#             min_index = j
#     array[i], array[min_index] = array[min_index], array[i] # 스와프

# # 측정 종료
# end_time = time.time()

# # 수행시간 출력
# print("선택 정렬 성능 측정 : ", end_time - start_time)

# # 배열을 다시 무작위 데이터로 초기화
# array = []
# for _ in range(10000):
#     array.append(randint(1, 100))

# # 기본 정렬 라이브러리 성능 측정
# start_time = time.time()

# # 기본 정렬 라이브러리 사용
# array.sort()

# # 측정 종료
# end_time = time.time()

# # 수행시간 출력
# print("기본 정렬 라이브러리 성능 측정 : ", end_time - start_time)