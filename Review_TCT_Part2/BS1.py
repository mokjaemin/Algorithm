


# 부품 찾기

n = 5
products = [8, 3, 7, 9, 2]
products.sort()

m = 3
find = [5, 7, 9]

def binary_search(length, i):
    min_index = length[0]
    max_index = length[1]
    if min_index > max_index:
        return False
    mid_index = (min_index + max_index)//2
    if i == products[mid_index]:
        return True
    elif i < products[mid_index]:
        return binary_search([min_index, mid_index-1], i)
    elif i > products[mid_index]:
        return binary_search([mid_index+1, max_index], i)


# for i in find:
#     result = binary_search([0, n], i)
#     if not result:
#         print("no", end=" ")
#         continue
#     print("yes", end=" ")
# print(" ")


n = 5
products = [8, 3, 7, 9, 2]
products.sort()
check = [0]*11
m = 3
find = [5, 7, 9]

for product in products:
    check[product] = 1
for i in find:
    if check[i] == 1:
        print("yes")
    else:
        print("no")