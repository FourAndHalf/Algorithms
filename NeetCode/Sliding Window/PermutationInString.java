public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] data = new int[26];
        int[] test = new int[26];

        for(char c : s1.toCharArray())                                      //! Time Complexity = O(n)
            data[c - 'a']++;
        
        for(int i = 0;i < s1.length();i++)                                  //! Time Complexity = O(n)
            test[s2.charAt(i) - 'a']++;

        int n = s1.length();

        for(int i = 0;i < s2.length()-n;i++) {                              //! Time Complexity = O(n)
            if(equalString(data, test)) return true;

            test[s2.charAt(i+n) - 'a']++;
            test[s2.charAt(i) - 'a']--;
        }

        return equalString(data, test);
    }                                                                       //! Total Time Complexity = O(n)

    public static boolean equalString(int[] s1, int[] s2) {
        for(int i = 0;i < 26;i++) {
            if(s1[i] != s2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        
        System.out.println(checkInclusion(s1, s2));
    }
}