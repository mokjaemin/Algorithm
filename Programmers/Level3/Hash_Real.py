


def solution(genres, plays):
    answer = []
    dic = {}
    
    for i, (genre, play) in enumerate(zip(genres,plays)):
        if genre in dic.keys():
            dic[genre] = [play+dic[genre][0], dic[genre][1]+[[play, i]]]
            continue
        dic[genre] = [play, [[play, i]]]            
    
    for genre, indexs in sorted(dic.items(), key=lambda x: -x[1][0]):
        print(genre, indexs)
        for index in sorted(indexs[1], key=lambda x: -x[0])[:2]:
            print(index)
            answer.append(index[1])

    return answer