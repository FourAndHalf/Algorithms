class Solution:
    def factorial(self, n):
        val = n
        if n > 1:
            val *= self.factorial(n-1)

        return val

if __name__ == "__main__":
    n = 6
    obj = Solution()

    val = obj.factorial(n)

    print(f"Factorial :", val)
