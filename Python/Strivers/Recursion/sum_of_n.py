class Solution:
    def calcSum(self, n):
        sumVal = n
        if n > 0:
            sumVal += self.calcSum(n-1)

        return sumVal

if __name__ == "__main__":
    n = 5
    obj = Solution()

    val = obj.calcSum(n)

    print(f"Sum to n numbers: ", val)
