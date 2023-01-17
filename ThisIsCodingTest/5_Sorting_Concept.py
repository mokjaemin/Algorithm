


# 정렬
# 데이터를 특정한 기준에 따서 순서대로 나열
# 이진탐색의 데이터 전처리 과정
# 종류 : 선택정렬, 삽입정렬, 퀵정렬, 계수정렬

# 1. 선택정렬
# 데이터가 무작위로 있을 때, 이 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고,
# 그 다음 작은 테이터를 선택해 앞에서 두번째 데이터와 바꾸는 과정을 반복
# '가장 작은 것을 선택'
# 스와프 - 특정한 리스트가 주어졌을 때 위치를 변경하는 작업을 의미
# 시간복잡도 - O(N**2)
# -> 가장 작은수를 찾기 위한 비교연산 n(n+1)/2
# -> 2중 반복문이 사용되면 보통 O(N**2)
# -> 정렬 중 가장 비효율적

# 예제
# 선택정렬을 활용한 오름차순
# idea - 인덱스 0부터 점점 커지면서 해당 위치에 맞는 가장 작은 수를 찾고 이를 배정
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_array = i
    for j in range(i+1, len(array)):
        if(array[min_array] > array[j]):
            min_array = j
    array[i], array[min_array] = array[min_array], array[i]
# print(array)


# 2. 삽입정렬
# 삽입 정렬은 특정한 데이터를 적절한 위치에 삽입한다는 의미
# 시간 복잡도 O(N**2)
# 선택정렬과 복잡도는 흡사하지만 정렬되있으면 시간에서 효율적, 최선의 경우 O(N)
# 데이터가 거의 정렬되어있다면 퀵정렬보다 효율적

# 예제
# 삽입정렬을 활용한 오름차순
# idea - i를 기준으로 값이 자신보다 작은 값이 나올때까지 왼쪽으로 이동
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
for i in range(1, len(array)):
    for j in range(i, 0, -1):
        if array[j] < array[j-1]:
            array[j], array[j-1] = array[j-1], array[j]
        else:
            break
# print(array)


# 3. 퀵정렬
# 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾼다.
# 가장 많이 사용되는 알고리즘
# 정렬 라이브러리의 근간이 됨.
# 재귀함수로 구현

# 과정
# 용어 - 피벗(기준), 분할방식(리스트를 분할)
# 분할방식의 종류가 여럿있지만 여기서는 리스트의 첫번째 데이터를 피벗으로 하는 '호어 분할' 활용
# 1. 리스트에서 왼쪽부터 피벗보다 큰수, 오른쪽부터 피벗보다 작은수를 찾고 위치를 바꾼다.
# 2. 두 선이 교차 즉, 왼쪽선은 오른쪽선이 이미 지난 수 중 피벗보다 큰수, 오른쪽 선은 반대 경우일 때
# 교차된다고 판단하고 교차되는 지점에 있는 수 중 작은 수와 피벗을 교체시킨다.
# 3. 이를 반복
# 4. 리스트 데이터가 1개가 될때까지 반복

# 시간 복잡도
# 평균 시간 복잡도 - O(NlogN)
# 최악 - O(N**2) -> 이미 데이터가 정렬이 어느정도 되어있는 경우 느려짐


# 예제 1
array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end): # 배열, pivot, last index
    if start >= end: # 원소가 1개인 경우 종료
        return
    pivot = start # pivot 설정
    left = start + 1 # 분할 1, 왼쪽 분할의 처음 리스트 지정
    right = end # 분할 2, 오른쪽 분할의 처음 리스트 지정
    while left <= right:
        while left <= end and array[left] <= array[pivot]:
            left += 1 # 피벗보다 작은 데이터
        while right > start and array[right] >= array[pivot]:
            right -= 1 # 피벗보다 큰 데이터
        if left > right: # 엇갈렸다면 작은 데이터와 피벗을 교체
            array[right], array[pivot] = array[pivot], array[right]
        else: # 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            array[left], array[right] = array[right], array[left]
    quick_sort(array, start, right-1)
    quick_sort(array, right+1, end)    

quick_sort(array, 0, len(array)-1) # 배열, pivot, 마지막 배열 인덱스 넘겨줌
# print(array)


# 예제 2
# 아이디어 - 피봇보다 작은 수들의 집합, 큰 수들의 집합 나누고 재귀함수로 집합마다 수행
array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array):
    if len(array) <= 1:
        return array
    
    pivot = array[0]
    tail = array[1:]

    left_side = [x for x in tail if x <= pivot]
    right_side = [x for x in tail if x > pivot]

    # 리스트 전체를 넘겨줌
    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

# print(quick_sort(array))


# 4. 계수정렬
# 별도의 리스트를 선언하고 그 안에 정렬에 대한 정보를 담는다
# 특정한 조건이 부합할때만 사용가능
# 정수, 가장 큰 데이터와 작은 데이터의 차이가 1,000,000 을 넘지 않을때
# 시간 복잡도
# 데이터의 개수 : N, 데이터 중 최대값 : K
# O(N+K)
# 정말 빠름
# 데이터의 크기가 한정되어 있고 데이터의 크기가 많이 중복되어 있을수록 유리

# 예제 1
# 가장 큰 데이터와 가장 작은 데이터에 맞추어 리스트 생성후 수 세기

array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]
count = [0]*(max(array)+1)
for i in range(len(array)):
    count[array[i]] += 1
new_array = []
for i in range(len(count)):
    for j in range(count[i]):
        # print(i, end=' ')
        new_array.append(i)
# print(new_array)



# 파이썬 라이브러리의 정렬
# 최악의 경우에도 O(Nlog(N)) 보장
# 데이터의 범위가 한정되어 있고 더 빠르게 동작해야 할때는 계수 정렬을 사용하자.

# 1. sorted()
# 파이썬 기본 정렬 라이브러리
# 퀵정렬과 비슷한 동작원리인 '병합정렬'로 제작
# 퀵정렬보단 느리지만 최악의 경우에도 O(Nlog(N))유지한다는 장점
array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]
result = sorted(array)


# 2. sort()
# 리스트 객체의 내장 함수
# 반환하지 않아도 알아서 정렬됨.
array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]
array.sort()

# key활용
array = [('바나나', 2), ('사과', 5), ('당근', 3)]
def setting(data):
    return data[1]
result = sorted(array, key=setting)
print(result)


# 코딩 테스트에서 정렬 알고리즘이 사용되는 3가지 문제 유형
# 1. 정렬 라이브러리로 풀 수 있는 문제
# 2. 정렬 알고리즘의 원리에 대해서 물어보는 문제 - 선택 정렬, 삽입 정렬, 퀵 정렬 등의 원리 활용
# 3. 더 빠른 정렬이 필요한 문제 - 퀵 정렬로는 풀수없으며 계수 정렬 등 다른 알고리즘을 이용하거나
# 문제에서 기존에 알려진 알고리즘의 구조적인 개선을 거쳐야 풀 수 있다.

