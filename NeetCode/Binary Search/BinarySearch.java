public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {                              //! Time Complexity = O(log n)
            int middle = left + (right - left)/2;
            if(target == nums[middle]) {
                return middle;
            } else if(target < nums[middle]) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }
        
        return -1;
    }                                                       //! Total Time Complexity = O(log n)

    public static void main(String[] args) {
        // int[] nums = {-1, 0, 3, 5, 9, 12};
        // int target = 9;

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;

        System.out.println(search(nums, target));
    }    
}
