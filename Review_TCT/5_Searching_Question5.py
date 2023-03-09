


# 공유기 설치

# 집의 개수
n = 5
# 설치할 공유기 수
c = 3
# 집의 위치 인덱스
array = [1, 2, 4, 8, 9]
print(array)

# 가능한 최소 갭
start = 1
# 가능한 최대 갭
end = array[-1] - array[0]
# 결과값 초기화
result = 0

while start <= end:
    # 가장 인접한 두 공유기 사이의 gap
    mid = (start + end) // 2
    value = array[0]
    count = 1
    print("mid : ", mid)
    for i in range(1, n):
        if array[i] >= value + mid:
            value = array[i]
            count += 1
    if count >= c:
        start = mid + 1
        result = mid
    else:
        end = mid - 1
print(result)

