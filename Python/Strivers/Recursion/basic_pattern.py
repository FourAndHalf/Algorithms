class Solution:
    def forwardRecursion(self, n):
        if n>0:
            print(f"Recursive write: ", n)
            self.forwardRecursion(n-1)

    def backtracking(self, n):
        if (n > 0):
            self.backtracking(n-1)
            print(f"Recursive write: ", n)

if __name__ == "__main__":
    n = 23
    obj = Solution()

    print("\nBACKTRACKING\n")
    obj.backtracking(n)
    
    print("\nFORWARD RECURSION\n")
    obj.forwardRecursion(n)
