public class Solution {
    public bool IsPalindrome(string s) {
        if (string.IsNullOrEmpty(s)) 
        {
            return false;
        }

        char[] array = s.ToLower()
                        .Where(c => !char.IsWhiteSpace(c) && !"?/!,\'.:;".Contains(c))
                        .ToArray();

        int left = 0;
        int right = array.Length-1;

        while (left < right) 
        {
            if (array[left] != array[right])
            {
                return false;
            }
            else 
            {
                left++;
                right--;
            }
        }

        return true;
    }
}
