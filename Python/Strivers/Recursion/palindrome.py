class Solution:
    def palindromeOrNot(self, s, idx):
        if (idx >= len(s)//2):
            return True

        if (s[idx] != s[len(s)-idx-1]):
            return False

        return self.palindromeOrNot(s, idx+1)

if __name__ == "__main__":
    s = "lordoftheringssgnirehtfodrol"
    s1 = "lol"
    s2 = "palindrome"
    obj = Solution()
    
    print(obj.palindromeOrNot(s, 0))
    print(obj.palindromeOrNot(s1, 0))
    print(obj.palindromeOrNot(s2, 0))
