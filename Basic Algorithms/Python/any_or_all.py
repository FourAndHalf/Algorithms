
nums = [1, 2, 3, None, 4, 5, 6, 7]

is_there_any = any(x > 4 for x in filter(lambda x: x, nums))
is_all_satisfy_condition = all(x > 0 for x in filter(lambda x: x, nums))

print(f"Is There Any: {is_there_any}")
print(f"Does All Satisfy Condition: {is_all_satisfy_condition}")

# Q. Check Inactive Users

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

is_there_any_inactive = any(x.get("active") is False for x in users)

print(f"Is there any inactive: {is_there_any_inactive}")
