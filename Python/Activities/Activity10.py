user_input = input("Enter space-separated numbers : ")

temp_tuple = tuple(int(item) for item in user_input.split())

print(temp_tuple)

print("The numbers divisible by 5 are : ")
for num in temp_tuple:
    if (num % 5 == 0 ):
        print(num)

