
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

result = {}

for user in sorted(filter(lambda x: x.get("id", 0) < 10, users),
                   key=(lambda x: x.get("id", 0)),
                   reverse=True):
    key = user["id"]
    result.setdefault(key, []).append(user)

for key, value in result.items():
    print(f"Key: {key} | Value: {value}")
