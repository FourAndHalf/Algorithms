public class DuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast) break;
        } while(true);

        int slow2 = 0;

        do {
            slow = nums[slow];
            slow2 = nums[slow2];

            if(slow == slow2) return slow;
        } while(true);
    }                                                       //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};

        System.out.println(findDuplicate(nums));
    }
}
