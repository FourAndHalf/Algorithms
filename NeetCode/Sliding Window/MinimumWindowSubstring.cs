
/*
 * Minimum Window Substring
 *
 * Given two strings s and t, return the shortest substring of s such that every character in t, 
 * including duplicates, is present in the substring.
 * If such a substring does not exist, return an empty string "".
 * You may assume that the correct output is always unique.
 *
 *
 * Test Case:
 *
 * Input: s = "OUZODYXAZV", t = "XYZ"
 * Output: "YXAZ"
 *
 * Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.
 *
 *
 * Time Complexity: O(n)    n: Length of string s
 * Space Complexity: O(m)   m: Number of unique characters in s & t
*/


public class Solution {
    public string MinWindow(string s, string t) {
        if (string.IsNullOrEmpty(t))
            return string.Empty;

        Dictionary<char, int> countT = new Dictionary<char, int>();
        Dictionary<char, int> countS = new Dictionary<char, int>();

        int have = 0, need = 0;
        int left = 0, right = 0;
        int resLen = s.Length+1;
        string res = string.Empty;

        for (int i = 0;i < t.Length;i++)
        {
            if (!countT.ContainsKey(t[i]))
            {
                countT[t[i]] = 1;
                need++;
            }
            else 
            {
                countT[t[i]]++;
            }        
        } 

        while (right < s.Length)
        {
            if (countS.ContainsKey(s[right]))
            {
                countS[s[right]]++;
            }
            else
            {
                countS[s[right]] = 1;
            }

            if (countT.ContainsKey(s[right]))
            {
                if (countT[s[right]] == countS[s[right]])
                {
                    have++;
                }
            }

            while (have == need)
            {
                if (resLen > (right-left+1))
                {
                    resLen = right-left+1;
                    res = s.Substring(left, right-left+1); 
                }

                countS[s[left]]--;

                if (countT.ContainsKey(s[left]))
                {
                    if (countT[s[left]] > countS[s[left]])
                    {
                        have--;
                    }
                }

                left++;
            }
            
            right++; 
        }
        
        return res;
    }
}

