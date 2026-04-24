class Solution:
    @staticmethod
    def insertion_sort(nums):
        for i in range(len(nums)):
            minIndex = i
            for j in range(i+1, len(nums)):
                minIndex = minIndex if nums[minIndex] < nums[j] else j

            temp = nums[i]
            nums[i] = nums[minIndex]
            nums[minIndex] = temp

        print(nums)

if __name__ == "__main__":
    obj = Solution()
    nums = [7, 4, 1, 5, 3]

    obj.insertion_sort(nums)

