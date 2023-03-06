


# 국영수

datas = [
    ['nsj', 80, 80, 80],
    ['Sunyoung',80, 70, 100],
    ['Sangkeun',70, 60, 100],
    ['Donghyuk',80, 60, 100],
    ['Soong', 50, 60, 90],
    ['Haebin', 50, 60, 100]
]
datas.sort(key = lambda x : (-int(x[1]), int(x[2]), -int(x[3]), x[0]))
for i in datas:
    print(i)

