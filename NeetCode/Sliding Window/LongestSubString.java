import java.util.HashSet;

public class LongestSubString {
    public static int lengthOfLongestSubString(String s) {
        int length = 0;
        int left = 0;
        char[] string = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        
        for(int right = 0;right < string.length;) {                         //! Time Complexity = O(n)
            while(set.contains(string[right])) {
                set.remove(string[left]);
                left += 1;
            }
            set.add(string[right]);
            right += 1;

            length = Math.max(length, right - left);
        }

        return length;
    }                                                                       //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubString(s));
    }
}
