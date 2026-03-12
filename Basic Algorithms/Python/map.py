
nums = [1, 2, 3, None, 4, 5, 6, 7]

# Q. Remove None values

squared = list(map(lambda x: x*x, filter(lambda x: x is not None, nums)))
even = list(filter(lambda x: x is not None and x%2==0, nums))

print(f"Squared: {squared}")
print("\n")
print(f"Even: {even}")

# Map takes all the values and overwrites them over the same index position as the master
# Filter takes out all other values that fail the condition and creates a new entity


# Q. Extract Emails, which aren't none, mapped to the name of the user

users = [
    {"id": 1, "name": "Alice Johnson", "email": "alice.johnson@example.com", "active": True, "role": "admin"},
    {"id": 2, "name": "Bob Smith", "email": "bob.smith@example.com", "active": False, "role": "user"},
    {"id": 3, "name": "Charlie Brown", "email": None, "active": True, "role": "user"},
    {"id": 4, "name": "Diana Prince", "email": "diana.prince@example.com", "active": True, "role": "manager"},
    {"id": 5, "name": "Ethan Clark", "email": "", "active": True, "role": "user"},
    {"id": 6, "name": "Fiona Davis", "email": "fiona.davis@example.com", "active": False, "role": "user"},
    {"id": 7, "name": "George Hill", "email": "george.hill@example.com", "active": True, "role": "admin"},
    {"id": 8, "name": "Hannah Lee", "email": "hannah.lee@example.com", "active": True, "role": "user"},
    {"id": 9, "name": "Ian Moore", "email": None, "active": False, "role": "user"},
    {"id": 10, "name": "Julia Adams", "email": "julia.adams@example.com", "active": True, "role": "manager"}
]

contact_info = list(tuple(map(lambda x: (x.get("id"), x.get("name"), x.get("email")),
                        filter(lambda x: x.get("email") and x.get("active") and x.get("role") == "user", users))))

contact_info = list(dict(map(lambda x: (x.get("name"), x.get("email")),
                        filter(lambda x: x.get("email") and x.get("active"), users))).values())

contact_info = dict(map(lambda x: (x.get("name"), x.get("email")),
                        filter(lambda x: x.get("email") and x.get("active"), users)))

print(contact_info)

