import pandas as pd
from pandas import ExcelWriter

data = {
    "FirstName" : ["Satvik", "Avinash", "Lahri"],
    "LastName" : ["Shah", "Kati", "Rath"],
    "Email" : ["satshah@example.com", "avinashk@example.com", "lahri.rath@example.com"],
    "PhoneNumber" : ["4537829158", "5892184058", "4528727830"]
}

df = pd.DataFrame(data)
print(df)

writer = writer = pd.ExcelWriter('../resources/excelData.xlsx')

df.to_excel(writer)
writer.save()
writer.close()

