
/**
 * Permutation In string
 *
 * You are given two strings s1 and s2.
 * Return true if s2 contains a permutation of s1, or false otherwise. 
 * That means if a permutation of s1 exists as a substring of s2, then return true.
 * Both strings only contain lowercase letters.
 *
 *
 * Test Case:
 * 
 * Input: s1 = "abc", s2 = "lecabee"
 * Output: true
 * Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
 *
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
*/

public class Solution {
    public bool CheckInclusion(string s1, string s2) {
        if (s1.Length > s2.Length)
            return false;

        int l = 0, r = s1.Length, matches = 0;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
                
        for (int i = 0;i < s1.Length;i++)
        {
            s1Count[s1[i] - 'a']++;
            s2Count[s2[i] - 'a']++;
        }

        for (int j = 0;j < 26;j++)
        {
            if (s1Count[j] == s2Count[j])
                matches++;
        }

        for (;r < s2.Length;r++, l++)
        {
            if (matches == 26)
                return true;

            int index = s2[r] - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index])
            {
                matches++;
            }
            else if (s1Count[index] + 1 == s2Count[index])
            {
                matches--;
            }

            index = s2[l] - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) 
            {
                matches++;
            }
            else if (s1Count[index] - 1 == s2Count[index])
            {
                matches--;
            }
        }

        return matches==26;
    }
}


/**
 * Brute Force Solution
 *
 * Checking one by one the matching
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
*/
public class Solution
{
    public bool CheckInclusion(string s1, string s2)
    {
        Dictionary<char, int> count1 = new Dictionary<char, int>();

        foreach (char c in s1)
        {
            if (count1.ContainsKey(c))
            {
                count1[c]++;
            }
            else
            {
                count1[c] = 1;
            }
        }

        int need = count1.Count;
        for (int i = 0; i < s2.Length; i++)
        {
            Dictionary<char, int> count2 = new Dictionary<char, int>();
            int cur = 0;

            for (int j = i; j < s2.Length; j++)
            {
                char c = s2[j];
                if (count2.ContainsKey(c))
                {
                    count2[c]++;
                }
                else
                {
                    count2[c] = 1;
                }

                if (!count1.ContainsKey(c) || count1[c] < count2[c])
                {
                    break;
                }

                if (count1[c] == count2[c])
                {
                    cur++;
                }

                if (cur == need)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
