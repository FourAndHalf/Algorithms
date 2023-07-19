public class validPalindrome {

    //* Brute Force Method
    // public static boolean palindromeFinder(String s) {
    //     String lowerS = s.toLowerCase();
    //     String palindromeString = lowerS.replaceAll("[^a-zA-Z0-9]", "");    //! O(n)

    //     boolean checker = true;
    //     char[] chars = palindromeString.toCharArray();                          //! O(n)
    //     for (int i = 0, j = chars.length-1; i < chars.length; i++, j--) {       //! O(n)
    //         if(chars[i] != chars[j]) {
    //             checker = false;
    //         }
    //     }

    //     return checker;
    // }                                                           //! Total Time Complexity = O(n)

    //* Optimized Method
    public static boolean palindromeFinder(String s) {
        if(s.isEmpty()) return true;

        int start = 0;
        int last = s.length()-1;

        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if(!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if(Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)){
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }                                                               //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // String s = "race a car";
        // String s = "0P";

        System.out.println(palindromeFinder(s));
    }
}