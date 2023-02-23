



# 괄호 변환

# 분리 함수
def seperating(seq):
    count0 = 0
    count1 = 0
    for i in range(len(seq)):
        if seq[i] == "(":
            count0 += 1
        else:
            count1 += 1
        
        if count0 > 1 and count1 > 1 and count0 == count1:
            result = True
            u = seq[:i+1]
            v = seq[i+1:]
            return [result, u, v]
        elif count0 == 1 and count1 == 1 and count0 == count1:
            result = True
            u = seq[:i+1]
            v = seq[i+1:]
            if len(v) == 0:
                result = False
                return [result, seq]
            return [result, u, v]

# 올바른지 체크 함수
def checkRight(seq):
    count0 = 0
    count1 = 0
    for i in range(len(seq)):
        if seq[i] == "(":
            count0 += 1
        else:
            count1 += 1
        
        if count0 < count1:
            return False
    return True

def main(seq):
    # 빈칸인지
    if seq == "":
        return seq
    # u, v 분리
    seperated = seperating(seq)

    # 분리 가능
    if seperated[0]:
        print("분리 가능 ", "u:", seperated[1], " v:", seperated[2])
        u = seperated[1]
        v = seperated[2]
        if checkRight(u):
            print("올바른 괄호 :", u)
            u = u
            v = main(v)
            return u + v
        else:
            print("올바르지 않은 괄호 :", u)
            v = main(v)
            result = "("
            result += v
            result += ")"
            index = []
            for i in range(len(u)):
                if i == 0 or i == len(u)-1:
                    continue
                else:
                    if u[i] == "(":
                        result += ")"
                    else:
                        result += "("
            return result
            
    # 분리 불가능
    else:
        print("분리 불가능 ", "seq:", seperated[1])
        seq = seperated[1]
        if checkRight(seq):
            print("올바른 괄호 : ", seq)
            return seq
        else:
            print("올바르지 않은 괄호 : ", seq)
            result = "()"
            return result
            

result = main("()))((()")
print(result)