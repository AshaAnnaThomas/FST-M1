num = int(input("Enter a number from 1 t0 10: "))

print("Multiplication table of number {}".format(num) )

for i in range (1, 11):
    temp = num * i
    print("{} * {} = {}".format(num, i, temp))