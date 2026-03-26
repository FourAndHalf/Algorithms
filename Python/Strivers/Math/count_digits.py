class Solution:
    def count_digits(self, n):
        import math
        digits = math.floor(math.log10(n))+1
        print(digits)

if __name__ == "__main__":
    n = 10000
    obj = Solution()
    obj.count_digits(n)
