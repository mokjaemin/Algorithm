

# 실전문제 2 - 성적이 낮은 순서로 학생 출력하기
# 입력 1 - 학생 수
# 입력 2 - 이름, 점수
# 출력 - 성적대로 이름 출력

n = int(input("입력 : "))
data = []
for i in range(n):
    input_data = input("입력 : ").split()
    data.append([input_data[0], int(input_data[1])]) # 튜플 () 입력 가능
    # int 없이 입력시 string으로 입력되고 sorted 제대로 동작 못함
data = sorted(data, key=lambda data:data[1], reverse=True)
for i in data:
    print(i[0], end=" ")
