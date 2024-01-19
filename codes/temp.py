import pandas as pd

headers = ['Name', 'Age', 'Weight']
values = ['Mohammad', 24, 65]

data = [['John', 28, 'New York'],
        ['Jane', 22, 'San Francisco'],
        ['Bob', 35, 'Los Angeles']]

df = pd.DataFrame(data, index=['A','B','C'], columns=['Name', 'Age', 'City'])