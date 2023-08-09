import java.util.Collections;
import java.util.HashMap;

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] string = s.toCharArray();
        int left = 0;
        int right = 0;
        int maximum = 0;
        map.put(string[right], 1);

        for(int i = 0;i < string.length-1;i++) {
            right++;
            if(map.containsKey(string[right])) {
                int count = map.get(string[right]);
                count += 1;
                map.put(string[right], count);
            } else {
                map.put(string[right], 1);
            }

            int count = Collections.max(map.values());

            if(((right - left) - count) <= k) {
                maximum = Math.max(maximum, right-left);
            }
            
            while(((right - left) - count) >= k) {
                left++;
                int counter = map.get(string[left-1]);
                counter--;
                map.put(string[left-1], counter);
            }
        }

        return maximum;
    }

    public static void main(String[] args) {
        // String s = "AABABBA";
        String s = "ABAB";
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }
}
