
class Solution:
    def isPalindrome(self, n):
        import copy
        n_copy = copy.deepcopy(n)
        rev_n = 0
        while(n > 0):
            rev_n = (rev_n*10) + n%10
            n = n//10
            
        print(rev_n == n_copy)

if __name__ == "__main__":
    n = 121
    obj = Solution()
    obj.isPalindrome(n)
