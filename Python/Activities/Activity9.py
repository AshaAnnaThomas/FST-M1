def getlist():
    try:
        list = []

        #if a non-int number is entered, it goes to except call
        print("Enter elements: ")
        while True:
            x = int(input())
            list.append(x)
    except:
        print(list)

    return  list

list1 = getlist()
list2 = getlist()

print(list1)
print(list2)

list3 = []

for num in list1:
    if (num % 2 != 0):
        list3.append(num)


for num in list2:
    if (num %2 == 0 ):
        list3.append(num)


print("new list is : {}".format(list3))



