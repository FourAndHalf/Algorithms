class Solution:
    def reverse_number(self, n):
        rev_n = 0
        while(n > 0):
            i = n % 10
            n = n // 10
            rev_n = rev_n * 10 + i

        print(rev_n)

if __name__ == "__main__":
    n = 253400
    obj = Solution()
    obj.reverse_number(n)
