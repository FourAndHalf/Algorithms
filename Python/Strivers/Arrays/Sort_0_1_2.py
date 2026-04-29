class Solution:
    @staticmethod
    def better_option(nums):
        counts = [0, 0, 0]
        for num in nums:
            count[num] += 1

    @staticmethod
    def refactor_approach(nums):
        """
        Refactored two-pass counting approach.
        """
        # Pass 1: Count frequencies
        counts = [0, 0, 0]
        for num in nums:
            counts[num] += 1

        print(f"Count 0:", counts[0])
        print(f"Count 1:", counts[1])
        print(f"Count 2:", counts[2])

        # Pass 2: Overwrite array based on counts
        idx = 0
        for val in range(3):
            for _ in range(counts[val]):
                nums[idx] = val
                idx += 1

        return nums

    @staticmethod
    def gemini_approach(nums):
        """
        Dutch National Flag algorithm: O(n) time and O(1) space in a single pass.
        """
        low = 0
        mid = 0
        high = len(nums) - 1

        while mid <= high:
            if nums[mid] == 0:
                nums[low], nums[mid] = nums[mid], nums[low]
                low += 1
                mid += 1
            elif nums[mid] == 1:
                mid += 1
            else:  # nums[mid] == 2
                nums[mid], nums[high] = nums[high], nums[mid]
                high -= 1
        return nums

if __name__ == "__main__":
    nums = [1, 0, 2, 1, 0]
    obj = Solution()
    
    print("Testing refactor_approach:")
    # Using a copy [:] to avoid modifying the original list for the next test
    print(obj.refactor_approach(nums[:]))
    
    print("\nTesting gemini_approach:")
    print(obj.gemini_approach(nums))
