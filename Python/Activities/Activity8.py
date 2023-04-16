try:
    list = []

    #if a non-int number is entered, it goes to except call
    print("Enter elements: ")
    while True:
        x = int(input())
        list.append(x)
except:

    print(list)

first_ele = list[0]
last_ele = list[-1]

if (first_ele == last_ele):
    print(True)
else:
    print(False)