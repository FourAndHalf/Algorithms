public class Solution
{
    public int Search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.Length - 1;

        while (left < right)
        {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right])
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }

        int pivot = left;

        int res = BinarySearch(0, pivot - 1, nums, target);

        if (res != -1)
            return res;

        return BinarySearch(pivot, nums.Length - 1, nums, target);
    }

    private int BinarySearch(int left, int right, int[] nums, int target)
    {
        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        return -1;
    }
}
