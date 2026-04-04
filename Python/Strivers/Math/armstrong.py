from math import log10
import math


class Solution:
    def armstrongVal(self, x):
        digitsCount = math.floor(log10(x)) + 1
        val = 0

        while (x > 0):
            digit = x%10
            val += math.pow(digit, digitsCount)
            x = x//10
        
        return val

if __name__ == "__main__":
    a = 370
    obj = Solution()

    if (a == obj.armstrongVal(a)):
        print("Is Armstrong")
    else:
        print("Nahh")
