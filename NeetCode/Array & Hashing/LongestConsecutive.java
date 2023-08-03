import java.util.HashSet;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {                                   //! Time Complexity = O(n)
            set.add(num);
        }

        int maxlen = 0;

        //? The starting number in a sequence doesn't have a number to the left
        //? So after pushing the array to a hashset we can check in linear time if any number have a number to the left to it

        for(int num : nums) {                                   //! Time Complexity = O(n)
            int j = 1;
            int count = 1;
            while(set.contains(num-j)) {                        //! Time Complexity = O(1)  
                count++;                                        //? Happens only n times in whole array
                j++;
            }
            
            if(maxlen < count) maxlen = count;
        }                                                       

        return maxlen;
    }                                                           //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 2, 3};
        
        System.out.println(longestConsecutive(nums));
    }
}
