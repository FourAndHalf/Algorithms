import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        if(s.length() != t.length()) {                                  
            return false;
        }

        char[] charOfS = s.toCharArray();
        char[] charOfT = t.toCharArray();

        Arrays.sort(charOfS);                                               //! Time Complexity = O(nlog n)
        Arrays.sort(charOfT);                                               //! Time Complexity = O(nlog n)

        for(int i = 0, count = 1;i < s.length();i++) {                      //! Time Complexity = O(n)
            if(map.containsKey(charOfS[i])) {
                count = map.get(charOfS[i]);
                count++;
            }
            map.put(charOfS[i], count);
            count = 1;

            if(map.containsKey(charOfT[i])) {
                count = map.get(charOfT[i]);
                count--;
            } else {
                return false;
            }
            map.put(charOfT[i], count);
            count = 1;
        }
        
        for(int x : map.values()) {                                         //! Time Complexity = O(n)
            if(x != 0) {
                return false;
            }
        }

        return true;
    }                                                                       //! Total Time Complexity = O(nlog n)

    public static boolean optimizedIsAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);                                                 //! Time Complexity = O(nlog n)
        Arrays.sort(charT);                                                 //! Time Complexity = O(nlog n)

        return Arrays.equals(charS, charT);
    }                                                                       //! Total Time Complexity = O(nlog n)

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}