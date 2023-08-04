public class MinimumRotatedArray {
    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length-1;

        if(nums[left] < nums[right]) return nums[left];

        while(left <= right) {
            int middle = left + (right-left)/2;
            min = Math.min(min, nums[middle]);

            if(nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        // int[] nums = {11, 13, 15, 17};

        System.out.println(findMin(nums));
    }
}
