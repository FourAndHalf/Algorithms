class Solution:
    def isPrime(self, x):
        import math
        count = 0

        for n in range(1, math.isqrt(x)+1):
            if (x%n == 0):
                count += 1
                
                if (n != x//n):
                    count += 1

        return True if (count == 2) else False

if __name__ == "__main__":
    a = 1000000006

    obj = Solution()

    print(f"Is Prime Value: ", obj.isPrime(a))
        
