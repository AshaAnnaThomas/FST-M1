import pandas as pd

dfr = pd.read_csv('../resources/userCredentials.csv')
print(dfr)

#to print only user names
print("The values in Usernames are : ")
print(dfr["Usernames"])

#to print the username as password of the second row
print("Username and password of the second row is : ")
print(dfr["Usernames"][1], dfr["Passwords"][1])

#to sort the usernames column in ascending order
print("Usernames in ascending order : ")
print(dfr.sort_values("Usernames"))

#to sort the passwords in descending order
print("Passwords in descending order: ")
print(dfr.sort_values("Passwords", ascending=False))