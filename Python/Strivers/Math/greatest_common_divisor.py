class Solution:
    def calcDivisors(self, x):
        divisors = []
        n = 1
        while(n <= x//2):
            if (x % n == 0):
                divisors.append(n)
            n += 1

        divisors.append(x)

        return divisors

    def findLargestDivisorFromList(self, x, divisors):
        for i in reversed(sorted(divisors)):
            if (x % i == 0):
                return i

        return 0

if __name__ == "__main__":
    a = 12
    b = 24

    obj = Solution()

    if a < b:
        divisors = obj.calcDivisors(a)
        largestDivisor = obj.findLargestDivisorFromList(b, divisors=divisors)

        print(f"Largest Divisor: ", largestDivisor)
    else:
        divisors = obj.calcDivisors(b)
        largestDivisor = obj.findLargestDivisorFromList(a, divisors=divisors)

        print(f"Largest Divisor: ", largestDivisor)
