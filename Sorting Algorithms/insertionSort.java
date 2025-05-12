//*             Insertion Sort             *//

//? Takes the array into a sorted and unsorted part.
//? Takes one element from unsorted part to sorted part each iteration and places it correctly.

import java.util.Arrays;

public class insertionSort{
    private static Integer[] testArray = {23, 45, 12, 67, 89, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 2, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90};

    public static Integer[] insertionSorter() {
        int n = testArray.length;
        for(int i = 1;i < n;i++) {                              //! Time Complexity = O(n)
            int current = testArray[i];
            int j = i-1;
            while(j >= 0 && current < testArray[j]) {           //! Time Complexity = O(n)
                testArray[j + 1] = testArray[j];
                j--;
            }
            testArray[j + 1] = current;
        }
        return testArray;
    }                                                           //! Total Time Complexity = O(n^2)
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSorter()));
    }
}