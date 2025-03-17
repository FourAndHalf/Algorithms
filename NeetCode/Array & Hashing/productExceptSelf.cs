public class Solution
{
    public int[] ProductExceptSelf(int[] nums)
    {
        int[] prefix = new int[nums.Length];
        int[] suffix = new int[nums.Length];
        int prdt = 1;

        if (nums == null)
            return new int[0];

        if (nums.Length == 0)
            return new int[0];

        prefix[0] = prdt;

        for (int i = 1; i < nums.Length; i++)
        {
            prdt = prdt * nums[i - 1];
            prefix[i] = prdt;
        }

        prdt = 1;
        suffix[nums.Length - 1] = prdt;
        for (int i = nums.Length - 2; i >= 0; i--)
        {
            prdt = prdt * nums[i + 1];
            suffix[i] = prdt;
        }

        for (int i = 0; i < nums.Length; i++)
        {
            prefix[i] = prefix[i] * suffix[i];
        }

        return prefix;

    }
}
