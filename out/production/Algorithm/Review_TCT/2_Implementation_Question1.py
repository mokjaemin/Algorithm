

# 럭키 스트레이트

n = input("입력 : ")
result1 = 0
result2 = 0
for i in range(len(n)):
    if i < len(n)/2:
        result1 += int(n[i])
    else:
        result2 += int(n[i])

if result1 == result2:
    print("LUCKY")
else:
    print("READY")
