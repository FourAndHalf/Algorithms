arr = [1, 2, 3, 4, 5]
window = 3

for i in range(len(arr) - window+1):
    print(arr[i: i+window])
