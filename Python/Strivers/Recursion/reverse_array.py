class Solution:
    def reverse_array(self, arr, n):
        left, right = 0, n-1

        while(left < right):
            arr[right] += arr[left]
            arr[left] = arr[right] - arr[left]
            arr[right] = arr[right] - arr[left]

            left += 1
            right -= 1

        print(f"Reversed Array: ", arr)
        
if __name__ == "__main__":
    n = [1,2,4,51,32]
    obj = Solution()

    obj.reverse_array(n, len(n))

