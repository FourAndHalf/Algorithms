from collections import Counter
import heapq

class Solution:
    def top_elements_1(self, nums, k):
        # Count frequency using Hashmap
        # Sort elements by frequency descending
        # Return first k elements

        # Time Complexity -> O(n log n)

        freq_map = Counter(nums)
        sorted_items = sorted(
                freq_map.items(),
                key = lambda x: x[1],
                reverse = True
            )
        result = []

        for num, freq in sorted_items[:k]:
            result.append(num)

        return result

    def top_elements_2(self, nums, k):
        # Count frequency using Hashmap
        # Create a min heap by keeping only first k elements

        # Time Complexity -> O(n log k)

        # Frequency Counting -> O(n)
        # Heap Operations    -> O(m log k)
        # Worst Case         -> O(n log k)
        
        freq_map = Counter(nums)
        min_heap = []

        for num, freq in freq_map.items():
            heapq.heappush(min_heap, (freq, num))

        if len(min_heap) > k:
            heapq.heappop(min_heap)

        result = []

        while min_heap:
            freq, num = heapq.heappop(min_heap)
            result.append(num)

        return result

    def top_elements_3(self, nums, k):
        # Count frequency using Hashmap
        # Use bucket sort to group numbers by frequency
        # Traverse buckets from highest frequency to lowest frequency

        # Time Complexity  -> O(n)
        # Space Complexity -> O(n)

        freq_map = {}

        for num in nums:
            freq_map[num] = freq_map.get(num, 0) + 1

        buckets = [[] for _ in range(len(nums) + 1)]

        for num, freq in freq_map.items():
            buckets[freq].append(num)
            
        result = []

        for freq in range(len(buckets) - 1, 0, 1):
            for num in buckets[freq]:
                result.append(num)

            if len(result) == k:
                return result

if __name__ == "__main__":
    nums = [1, 1, 1, 2, 2, 3]
    k = 2

    obj = Solution()

    obj.top_elements_1(nums, k)

