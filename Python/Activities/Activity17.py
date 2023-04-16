import pandas as pd

data = {
    "Usernames" : ["admin", "Charles", "Deku"],
    "Passwords" : ["password", "Charl13", "AllMight"]
}

#to create a dataFrame with the data
df = pd.DataFrame(data)

print(df)

df.to_csv('../resources/userCredentials.csv', index=False)

dfr = pd.read_csv('../resources/userCredentials.csv')
print(dfr)