import java.util.Arrays;

public class validAnagramArray {
    public static boolean isAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);                                         //! Time Complexity = O(nlog n)
        Arrays.sort(charT);                                         //! Time Complexity = O(nlog n)

        return Arrays.equals(charS, charT);
    }                                                               //! Total Time Complexity = O(nlog n)

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}