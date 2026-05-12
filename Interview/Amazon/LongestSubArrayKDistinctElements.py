class Solution:
    def longest_subarray(self, s, k):
        if not s or k == 0:
            return 0

        freq = {}
        left = 0
        maxlength = 0

        for right in range(len(s)):
            char = s[right]

            freq[char] = freq.get(char, 0) + 1

            while len(freq) > k:
                l_char = s[left]
                freq[l_char] -= 1

                if freq[l_char] == 0:
                    del freq[l_char]

                left += 1

            maxlength = max(maxlength, right-left+1)

        return maxlength
