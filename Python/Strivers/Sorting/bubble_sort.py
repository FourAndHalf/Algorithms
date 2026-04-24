class Solution:
    @staticmethod
    def bubble_sort(nums):
        is_swapped = False
        counter = 0
        for i in reversed(range(len(nums))):
            is_swapped = False
            for j in range(0, i):
                if nums[j] > nums[j+1]:
                    temp = nums[j]
                    nums[j] = nums[j+1]
                    nums[j+1] = temp
                    counter += 1
                    is_swapped = True

            if not is_swapped:
                break

        print(f"Count of swaps: {counter}")
        print(nums)

if __name__ == "__main__":
    obj = Solution()
    numsUnsorted = [7, 4, 1, 5, 3]
    nums = [1, 3, 4, 5, 7]

    obj.bubble_sort(nums)

