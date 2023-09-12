


# 치킨 배달

from itertools import combinations
n, m = map(int, input().split()) # 맵의 크기, 치킨집의 수 입력
chicken, house  = [], [] # 집과 치킨집의 위치 저장

for r in range(n):
    data = list(map(int, input().split()))
    for c in range(n):
        if data[c] == 1:
            house.append((r, c))
        elif data[c] == 2:
            chicken.append((r, c))

# 치킨집 중 m개로 이루어진 조합
candidates = list(combinations(chicken, m))


def get_sum(condidate): # candidate - (1, 0), (2, 1) 등 치킨집의 위치
    result = 0
    for hx, hy in house: # 집의 위치
        temp = 1e9
        for cx, cy in candidate: # 선택된 치킨집의 위치
            temp = min(temp, abs(hx-cx) + abs(hy-cy))
        result += temp
    return result


result = 1e9
# 조합을 하나하나 벗겨가며 그 결과가 가장 작은 것을 선택
for candidate in candidates:
    result = min(result, get_sum(candidate))
print(result)