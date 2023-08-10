import java.util.Collections;
import java.util.HashMap;

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] string = s.toCharArray();
        int left = 0;
        int right = 0;
        int maximum = 0;

        while(right < string.length) {                              //! Time Complexity = O(n)
            if(map.containsKey(string[right])) {
                int count = map.get(string[right]);
                count += 1;
                map.put(string[right], count);
            } else {
                map.put(string[right], 1);
            }

            int max = Collections.max(map.values());

            while(((right-left)-max) >= k) {                        //! Time Complexity = O(26)
                int count = map.get(string[left]);
                count--;
                map.put(string[left], count);
                left++;
            }
            
            maximum = Math.max(maximum, right-left+1);
            right++;
        }
        return maximum;
    }                                                               //! Total Time Complexity = O(26n)

    public static void main(String[] args) {
        // String s = "AABABBA";
        String s = "ABAB";
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }
}
