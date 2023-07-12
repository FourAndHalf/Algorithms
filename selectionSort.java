//*             Selection Sort             *//

//? Loops over the entire array and swaps only once the lowest element every time.
//? One Swap per One Iteration.

import java.util.Arrays;

public class selectionSort {

    private static Integer[] testArray = {23, 45, 12, 67, 89, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 2, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90};

    public static Integer[] selectionSorter() {
        int n = testArray.length;
        for(int i = 0;i < n-1;i++) {                                    //! Time Complexity = O(n)
            int smallest = i;
            for(int j = i+1;j < n;j++) {                                //! Time Complexity = O(n)
                if(testArray[smallest] > testArray[j]) {
                    smallest = j;
                }
            }
            if(smallest != i) {
                int temp = testArray[i];
                testArray[i] = testArray[smallest];
                testArray[smallest] = temp;
            }                                                           //! Time Complexity = O(n^2)
        }
        return testArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSorter()));
    }
}