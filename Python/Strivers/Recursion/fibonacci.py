class Solution:
    def fibonacci(self, n, a, b):
        if (a+b <= n):
            b += a
            a = b - a

            print(b)
            self.fibonacci(n, a, b)

if __name__ == "__main__":
    n = 26
    obj = Solution()

    print(0)
    print(1)
    obj.fibonacci(n, 0, 1)
