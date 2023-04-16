import pandas as pd

df = pd.read_excel('../resources/excelData.xlsx')
print(df)

#to print the number of rows and columns in the excel sheet

print("Number of rows are columns are : " , df.shape)

print(df["Email"])

print(df.sort_values("FirstName"))