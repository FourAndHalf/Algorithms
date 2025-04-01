public class Solution
{
    public List<List<string>> GroupAnagrams(string[] strs)
    {

        if (strs.Length == 0)
        {
            return new List<List<string>>();
        }

        Dictionary<string, List<string>> map = new Dictionary<string, List<string>>();

        foreach (string str in strs)
        {
            int[] val = new int[26];

            foreach (char c in str)
            {
                val[c - 'a']++;
            }

            string s = String.Join(',', val);

            if (map.ContainsKey(s))
            {
                map[s].Add(str);
            }
            else
            {
                map.Add(s, new List<string> { str });
            }
        }

        return map.Values.ToList<List<string>>();
    }
}
