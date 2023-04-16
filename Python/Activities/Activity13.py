def sum(numbers):

    temp = 0

    for num in numbers:
        temp +=  num

    return  temp

num_list = [7, 9, 3, 6, 9, 1]

result = sum(num_list)

print(("Sum of all elements is {}". format(result)))
