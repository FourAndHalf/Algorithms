class Solution:
    def map_value(self, arr):
        freq = {}

        for n in arr:
            freq[n] = freq.get(n, 0) + 1

        return freq

if __name__ == "__main__":
    arr = [10,5,10,15,10,5];

    obj = Solution()

    freq = obj.map_value(arr)

    print(f"Frequency of 10: ", freq[10])
    print(f"Max occured key: ", max(freq, key=freq.get))
