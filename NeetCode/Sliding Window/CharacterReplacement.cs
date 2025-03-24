public class Solution
{
    public int CharacterReplacement(string s, int k)
    {
        int left = 0;
        int right = 0;
        int mostOccurrence = 0;
        int max = 0;
        bool isValid = true;

        Dictionary<char, int> hashMap = new Dictionary<char, int>();

        if (string.IsNullOrEmpty(s))
        {
            return 0;
        }

        while (right < s.Length)
        {
            if (hashMap.ContainsKey(s[right]))
            {
                hashMap[s[right]]++;
            }
            else
            {
                hashMap.Add(s[right], 1);
            }

            if (mostOccurrence < hashMap[s[right]])
            {
                mostOccurrence = hashMap[s[right]];
            }

            isValid = (right - left + 1 - mostOccurrence) <= k ? true : false;

            while (!isValid)
            {
                hashMap[s[left]]--;
                left++;

                if (mostOccurrence < hashMap[s[left]])
                {
                    mostOccurrence = hashMap[s[left]];
                }

                isValid = (right - left + 1 - mostOccurrence) <= k ? true : false;
            }

            if (max < right - left + 1)
            {
                max = right - left + 1;
            }

            right++;
        }

        return max;
    }
}
