


# 성적이 낮은 순서로 학생 출력하기

n = int(input("입력 : "))
array = []
for i in range(n):
    array.append(list(input("입력 : ").split()))

def setting(data):
    return data[1]
print(sorted(array, key=setting))