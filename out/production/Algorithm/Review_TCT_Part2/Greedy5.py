



# 모험가 길드

people = list(map(int, input("입력 : ").split()))
people.sort()
print(people)

count = 0
result = 0 
team = []
for i in people:
    count = i
    team.append(i)
    if len(team) == count:
        print(team)
        result += 1
        team = []
print(result)