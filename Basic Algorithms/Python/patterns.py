items = ["apple", "banana", "orange", "pomegranate", "mosambi", "kiwi"]

for index, value in enumerate(items):
    print(index, value)


# Q1. Print list with line numbers

for index, value in enumerate(items):
    print(index+1, value)


# Q2. Replace items at even index with uppercase

for index, value in enumerate(items):
    if index%2 == 0 and index != 0:
        print(value.upper())
    else:
        print(value)


# Q3. Find first element longer than 5 characters

for index, value in enumerate(items):
    if len(value) > 5:
        print(value)
        break
