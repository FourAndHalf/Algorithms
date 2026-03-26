class Solution:
    def pattern1(self, n):
        for i in range(1, n+1, 1):
            print(i*"*")

        for i in reversed(range(1, n+1, 1)):
            print(i*"*")

    def pattern2(self, n):
        for i in range(1, n+1, 1):
            if i%2==1:
                print("1" + (i//2)*"01")
            else:
                print((i//2)*"01")

    def pattern3(self, n):
        for i in range(1, n+1, 1):
            j = 1
            while(j<=i):
                print(j, end="")
                j += 1
            
            print(2*(n-i)*" ", end="")

            j = i
            while(j>0):
                print(j, end="")
                j -= 1

            print()

    def pattern4(self, n):
        j = 1
        for i in range(1, n+1, 1):
            count = 0
            while(count<i):
                print(j, end="")
                j += 1
                count += 1
            print()

    def pattern5(self, n):
        for i in range(1, n+1, 1):
            for j in range(1, i+1, 1):
                print(chr(64+j), end="")
            print()

    def pattern6(self, n):
        for i in reversed(range(1, n+1, 1)):
            for j in range(1, i+1, 1):
                print(chr(64+j), end="")
            print()

    def pattern7(self, n):
        for i in range(1, n+1, 1):
            print(i*chr(64+i))

    def pattern8(self, n):
        for i in range(1, n+1, 1):
            print((n-i)*" ", end="")
            j = 1
            while(j<=i):
                print(chr(64+j), end="")
                j += 1

            j -= 1
            while(j>1):
                j -= 1
                print(chr(64+j), end="")

            print()

    def pattern9(self, n):
        for i in range(n):
            while(i>=0):
                print(chr(64+(n-i)), end="")
                i -= 1
            print()

    def pattern10(self, n):
        for i in range(n):
            print((n-i)*"*", end="")
            print(2*(n - (n-i))*" ", end="")
            print((n-i)*"*")

        for i in reversed(range(n)):
            print((n-i)*"*", end="")
            print(2*(n - (n-i))*" ", end="")
            print((n-i)*"*")

    def pattern11(self, n):
        for i in reversed(range(n)):
            print((n-i)*"*", end="")
            print(2*(n - (n-i))*" ", end="")
            print((n-i)*"*")

        for i in range(1, n, 1):
            print((n-i)*"*", end="")
            print(2*(n - (n-i))*" ", end="")
            print((n-i)*"*")

    def pattern12(self, n):
        for i in range(n):
            if (n-i) == n or (n-i) == 1:
                print(n*"*")
            else:
                print("*" + (n-2)*" " + "*")

    def pattern13(self, n):
        size = 2*n-1
        center = n-1
        for i in range(size):
            for j in range(size):
                value = max(abs(i - center), abs(j - center))+1
                print(value, end = " ")
            print()


if __name__ == "__main__":
    n = 5
    obj = Solution()
    obj.pattern13(n)
