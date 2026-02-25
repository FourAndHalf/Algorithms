
for i in range(5):
    print(i)                # 01234


for i in range(2, 10, 2):   # StartValue, EndValue, IncrementBy
    print(i)                # 2468


for i in reversed(range(5)):
    print(i)                # 43210



# Q1. Loop from 1 to  100 skipping multiples of 3

for i in range(3, 100, 3):
    print(i)


# Q2. Print numbers backwards from 50 to 0

for i in reversed(range(51)):
    print(i)


# Q3. Generate squares of numbers 1 - 20

for i in range(1, 21, 1):
    print(i*i)
