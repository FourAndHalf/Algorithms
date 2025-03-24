public class Solution
{
    public int LengthOfLongestSubstring(string s)
    {
        int left = 0;
        int right = 0;
        int max = 0;
        List<char> charList = new List<char>();

        if (string.IsNullOrEmpty(s))
        {
            return 0;
        }

        while (right < s.Length)
        {
            while (charList.Contains(s[right]))
            {
                charList.Remove(s[left]);
                left++;
            }

            charList.Add(s[right]);

            if (max < (right - left + 1))
            {
                max = right - left + 1;
            }

            right++;
        }

        return max;
    }
}
