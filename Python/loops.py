attempt = 0

while attempt < 3:
    print("Trying..")
    attempt += 1


# Q1. Password retry system

password_retry = 3
attempt = 0
user_input = ""

# while attempt < password_retry:
#     user_input = input("Please enter password: ")
#
#     attempt += 1
#     if attempt == 3:
#         break
#
#     print("Try again..")
#
# print(f"You gave the password as: {user_input}")

# Q2. Loop until user enters valid number

import re

pattern = r'\b-?\d+\b'
text = "There are 30 apples and 20 oranges, the temperature in town dropped by -5 degrees."

match = re.findall(pattern, text)

print(f"Found them: {match}")

# Q3. Simulate API retry with exponential backoff

import random

class RecoverableException(Exception):
    """Exception that indicates errors can be recovered or retrieved"""
    pass

attempt = 0
retry = 3

def fetch_data():
    if random.choice([True, False]):
        raise RecoverableException("Temperory failure, please retry..")

for attempt in range(retry):
    try:
        fetch_data()
        print("Operation succeeded")
        break
    except RecoverableException as e:
        print(f"Attempt {attempt+1} failed: {e}")
else:
    print("All attempts failed, cannot retry")
