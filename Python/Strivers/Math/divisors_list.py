class Solution:
    def divisorList(self, x):
        import math

        divisors = []

        for n in range(1, math.isqrt(x)+1):
            if (x%n == 0):
                divisors.append(n)
                
                if (n != x//n):
                    divisors.append(x//n)

            n += 1

        return sorted(divisors)

if __name__ == "__main__":
    a = 125

    obj = Solution()

    print(f"Divisor set: ", obj.divisorList(a))
        
