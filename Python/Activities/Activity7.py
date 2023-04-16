try:
    list = []

    #if a non-int number is entered, it goes to except call
    print("Enter elements: ")
    while True:
        x = int(input())
        list.append(x)
except:

    print(list)

sum = 0

for ele in range(0, len(list)):
    sum += list[ele]

print("Sum of the elements in the list : {}".format(sum))

