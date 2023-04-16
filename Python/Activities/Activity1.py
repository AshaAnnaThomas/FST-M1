name = input("Enter your name : ")
age = input ( "Enter your age :")

year = (2023 - int(age))+ 100
#year = (100 - int(age)) + 2023


message = ("Dear {}, you will turn 100 in {}")
print(message.format(name, year))

