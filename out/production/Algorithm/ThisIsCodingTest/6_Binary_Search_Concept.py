


# 1. 순차 탐색
# 리스트 안에 잇는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차례대로 확인하는 방법
# 시간복잡도 : O(N)

# 순차탐색 구현
# 나의 답변
# num, name = input("입력 : ").split()
# num = int(num)
# lst = []
# lst.append(input("입력 : ").split())
# for i in range(num):
#     if lst[0][i] == name:
#         print(i+1)
#         break


# 답안
# def sequential_search(n, target, array):
#     for i in range(n):
#         if array[i] == target:
#             return i + 1
        
# input_data = input().split()
# n = int(input_data[0])
# target = input_data[1]
# array = input().split()
# print(sequential_search(n, target, array))




# 2. 이진탐색
# 반으로 쪼개면서 탐새가기
# 배열 내부가 순서대로 정렬되어 있어야 사용할 수 있는 탐색
# 시작점, 중간점, 끝점을 두고 찾으려는 데이터와 중간점을 비교해가면서 반복적으로 줄여나감
# 중간점이 실수일 경우, 소수점을 버린다.
# 또한 다음 이동시 중간점이 이미 타겟보다 크거나 작으면 타겟에 해당이 될 수 없으므로 
# 중간점-1 또는 중간점+1 을 다음으로 보낸다.
# 시간 복잡도 - O(logN) -> 밑은 항상 2임
# (확인할때마다 확인하는 원소의 개수가 절반으로 줄어들기 때문에)
# 데이터가 1000만을 넘어가면 이진탐색을 사용하자.
# 방법 - 재귀함수, 반복문


# 에제1. 재귀함수 사용
# 나의 답변
# def binary_search(target, array, start, end):
#     if end < start:
#         return None
#     mid = (start+end)//2
#     if(array[mid] == target):
#         return mid+1
#     elif(array[mid] > target):
#         return binary_search(target, array, start, mid-1)
#     elif(array[mid] < target):
#         return binary_search(target, array, mid+1, end)


# n, target = map(int,input("입력 : ").split()) # 배열의 크기와 찾으려는 타겟
# array = list(map(int,input("입력 : ").split())) # 배열
# array = sorted(array)
# result = binary_search(target, array, 0, n-1)
# print(result)

# 답안
# def binary_search(array, target, start, end):
#     if start > end:
#         return None
#     mid = (start + end) // 2
#     if array[mid] == target:
#         return mid
#     elif array[mid] > target:
#         return binary_search(array, target, start, mid-1)
#     else:
#         return binary_search(array, target, mid+1, end)


# 예제2. 반복문을 구현

def binary_search(target, array, start, end):
    while(1):
        if end < start:
            return None
        mid = (start+end)//2
        if(array[mid] == target):
            return mid+1
        elif(array[mid] > target):
            end = mid - 1
        else:
            start = mid + 1


n, target = map(int,input("입력 : ").split()) # 배열의 크기와 찾으려는 타겟
array = list(map(int,input("입력 : ").split())) # 배열
array = sorted(array)
result = binary_search(target, array, 0, n-1)
print(result)


# 트리 자료 구조

# 대부분의 데이터베이스는 트리 자료구조를 갖고 있고 이진 탐색과 같은 탐색기법을 이용하면
# 빠르게 이를 탐색할 수 있다.

# 트리의 특징
# 1. 부모 노드와 자식 노드의 관계로 표현
# 2. 트리의 최상단 노드를 루트노드라고 한다.
# 3. 트리의 최하단 노드를 단말노드라고 한다.
# 4. 트리에서 일부를 떼어내도 트리구조이며 이를 서브트리라 한다.
# 5. 트리는 파일 시스템과 같이 계층적이고 정렬된 데이터를 다루기에 적합하다.

# 트리의 종류
# 이진 탐색 트리
# 이진 탐색이 동작할 수 있도록 고안된, 효율적인 탐색이 가능한 자료구조
# 특징
# 1. 부모 노드보다 왼쪽 자식노드가 작다.
# 2. 부모 노드보다 오른쪽 자식노드가 크다.

import sys
input_data = sys.stdin.readline().rstrip()
print(input_data)