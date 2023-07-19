import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
    public static List<List<String>> anagramCalculator(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs) {                                               //! Time Complexity = O(n)
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if(!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }                                                                           //! Total Time Complexity = O(n)
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(anagramCalculator(strs));
    }
}