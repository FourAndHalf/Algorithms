public class ElementInRotatedArray {
    public static int findElement(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right) {
            int middle = left + (right-left)/2;
            if(nums[middle] == target) return middle;
            
            //? Left Sorted Portion
            if(nums[left] <= nums[middle]) {
                if(nums[left] <= target && target <= nums[middle] ) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            //? Right Sorted Portion
            } else {
                if(nums[middle] <= target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;

        System.out.println(findElement(nums, target));
    }
}
