class Solution:
    @staticmethod
    def atoi(s):
        s = s.lstrip()
        if not s:
            return None
        
        def get_prefix(string):
            if not string or string[0].isspace():
                return ""
            return string[0] + get_prefix(string[1:])
        
        word = get_prefix(s)
        try:
            return int(word)
        except ValueError:
            return None


if __name__ == "__main__":
    s = "4826 is a number"
    s = "+7283"
    result = Solution.atoi(s)
    print(f"The first value is: {result}")
