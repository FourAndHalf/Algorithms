import heapq

names = ["A", "B", "C", "D", "E", "F", "G", "H"]
scores = [90, 92, 70, 60, 90, 29, 26, 92, 44]

math_scores = [45, 23, 53, 59]
physics_scores = [23, 42, 11, 34]
biology_scores = [56, 45, 67, 45]

store = {}

for name, score in zip(names, scores):
    print(name, score)

z = list(zip(names, scores))
print(z)

names_unzipped, scores_unzipped = zip(*z)
print(names_unzipped)
print(scores_unzipped)

result = [x + y + z for x, y, z in zip(math_scores, physics_scores, biology_scores)]
print(result)

# Q1. Combine two lists into dict

for name, score in zip(names, scores):
    store[name] = score

store = dict(zip(names, scores))

for name, score in store.items():
    print(f"Name: {name} - Score: {score}")


# Q2. Find the highest score with name

name, score = max(zip(names, scores), key=lambda x: x[1])
print("Highest Score")
print(f"Name: {name}  Score: {score}")


# Q3. Get top 3 highest scores

z = list(zip(names, scores))
print(z)

top_3_scores = sorted(zip(names, scores), key=lambda x: x[1], reverse=True)[:3]
top_3_scores = heapq.nlargest(3, zip(names, scores), key=lambda x: x[1])            

print("Top 3 Scores")
print(top_3_scores)


# Q4. Handle tie scores

handle_tie_scores = sorted(zip(names, scores), key=lambda x: (-x[1], x[0]))[:3]

print("Top 3 Scores")
print(handle_tie_scores)


vals = sorted(zip(names, scores), key=lambda x: x[1], reverse=True)

top_n = 3
threshold = vals[top_n-1][1]

handle_tie_scores = [p for p in vals if p[1] >= threshold]

print("Top 3 Scores")
print(handle_tie_scores)


# Q3. Detect mismatched list lengths
