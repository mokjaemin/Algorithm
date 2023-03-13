


# 효율적인 화폐 구성

m = 14
arrays = [1, 4, 5, 7]
check = [100000]*(m+1)

for array in arrays:
    check[array] = 1
    for amount in range(1, m+1):
        check[amount] = min(check[amount], check[amount-array]+1)
    print(check)



# for array in arrays:
#     check[array] = 1
# for amount in range(1, m+1):
#     for array in arrays:
#         if amount - array >= 0:
#             check[amount] = min(check[amount], check[amount-array] + 1)
#         else:
#             continue


print(check)