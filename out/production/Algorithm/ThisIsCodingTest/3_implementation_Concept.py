
# 3. 구현(Implementaion)
# 머리속에 있는 알고리즘을 소스코드로 바꾸는 과정
# 구현 유형의 문제 
# - 풀이를 떠올리는 것은 쉽지만 소스코드로 옮기기 어려운 문제
# - 프로그래밍 언어의 문법에 능숙하고 코드 작성 속도가 빠른 사람에게 유리한 문제
# 구현에서 어려운 문제
# - 알고리즘은 간단한데 지나칠만큼 길어지는 문제
# - 특정 소수점까지 출력해야하는 문제
# - 문자열이 주어졌을 때 한 문자 단위로 끊어서 리스트에 넣어야 하는 문제
# 분리한 경우
# - 프로그래밍 문법을 정확하게 숙지를 못했거나 라이브러리 사용 경험이 부족
# 종류
# 1. 완전탐색 : 모든 경우의 수를 주저 없이 다 계산하는 해결 방밥
# 2. 시뮬레이션 : 문제에서 제시한 알고리즘을 한 단계씩 차례대로 직접 수행

# 구현 시 고려해야 할 메모리 제약 사항
# - int->4바이트
# - 보통 제약을 128~512MB로 규정(M=백만)
# - 데이터 처리량이 많은 예제는 꼭 메모리 제한을 고려
# - 항상 메모리 사용량 제한보다 더 적은 크기의 메로리를 사용해야 한다는 점을 기억하자.

# 채점 환경
# - 보통 시간제한 1초, 메모리 제한 128MB로 규정
# - 파이썬은 1초에 2000만번의 연산정도를 수행한다고 생각.
# - 알고리즘 문제를 풀 때는 시간 제한과 데이터의 개수를 먼저 확인한 뒤에
# 이 문제를 어느 정도의 시간 복잡도의 알고리즘으로 작성해야 풀 수 있을 것인지 예측할 수 있어야 한다.

# 에제 4-1, 상하좌우
# 지도 NxN 공간속에서 왼쪽 가장 위(1,1), 오른쪽 가장 아래(N, N)설정
# L, R, U, D 등이 적힌 경로를 따라 이동 후 최종 목적지 출력
# 지도 범위 벗어나면 움직임 없음
# 시작점은 (1, 1)로 설정
# 입력 - 공간의 크기 N과 경로 입력
# 출력 - 최종 목적지

# 나의 답안
# n = int(input("입력 : "))
# route = list(input("경로 : ").split())
# x = 1
# y = 1
# xlim = x + n - 1
# ylim = y + n - 1
# for i in route:
#     if(i == 'L'):
#         x -= 1
#         if(x < 1):
#             x += 1
#     elif(i == 'R'):
#         x += 1
#         if(x > xlim):
#             x -= 1
#     elif(i == 'U'):
#         y += 1
#         if(y > ylim):
#             y -= 1
#     elif(i == 'D'):
#         y -= 1
#         if(x < 1):
#             x += 1
# print(x ,y)

# 정리
# 연산횟수는 이동횟수에 비례
# 따라서 시간복잡도는 O(N)
# 또한 일련의 명령에 따라서 개체를 차례대로 이동시킨다는 점에서 시뮬레이션형으로 이 문제는 분류됨. 

# 답안
# n = int(input())
# x, y = 1, 1
# plans = input().split()
# dx = [0, 0, -1 , 1]
# dy = [-1, 1, 0, 0]
# move_types = ['L', 'R', 'U', 'D']
# for plan in plans:
#     for i in range(len(move_types)):
#         if plan == move_types[i]:
#             nx = x + dx[i]
#             ny = y + dy[i]
#     if nx < 1 or ny < 1 or nx > n or ny > n:
#         continue
#     x,y = nx,ny
# print(x, y)

# 예제 4-2 시각
# 정수 N이 입력되면 N시 59분 59초까지 중 3이 포함된 모든 경우의 수

# 나의 답안
# n = int(input("입력 : "))
# count = 0
# for x in range(0, n+1): # 59분 59초까지 인것을 고려못해 n으로 설정했었음
#     if("3" in str(x)): # 시 고려
#         count += 3600
#     else:
#         for y in range(0, 60): # 분 고려
#             if("3" in str(y)):
#                 count += 60
#             else:
#                 count += 15 # 초 고려
# print(count)

# 답안지 및 정리
# 하루는 86400초이므로 검사해야하는 데이터가 100,000이 되지 않음
# 따라서 문자열 연산을 이용해 해결 가능
# 이는 완전 탐색 유형임 - 가능한 경우의 수를 모두 검사해보는 탐색 방법
# 비효율적인 시간복잡도를 가지고 있으며 데이터 개수가 큰 경우에 정상적으로 동작하지 않을 수 있음.
# 검사해야하는 데이터가 100만개 이하일 때 완전탐색을 사용
# 아이디어 : 032723 이런식으로 시각 전체를 문자로 만들어 검사

# h = int(input())
# count = 0
# for i in range(h+1):
#     for j in range(60):
#         for k in range(60):
#             if '3' in str(i) + str(j) + str(k):
#                 count += 1
# print(count)