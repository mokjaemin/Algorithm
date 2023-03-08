


# 공유기 설치

from itertools import permutations

def main(array, c, start, end):
    if c == 2:
        return array[end] - array[start]
    else:
        final = 0
        for test in tests:
            print(min(test))
            result = min((array[end] - max(test)), (min(test) - array[start]))
            if final < result:
                final = result
        return final





n = 5
c = 3
array = [1, 2, 8, 4, 9]
array.sort()
tests = list(permutations(array, c-2))
result = main(array, c, 0, len(array)-1)
print(result)