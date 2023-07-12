//*             Bubble Sort             *//

//? Loops (n-1) times takes the largest element every time and keeps it at the end.

import java.util.Arrays;

public class bubbleSort {
    
    private static Integer[] testArray = {23, 45, 12, 67, 89, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 2, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90};

    private static Integer[] bubbleSorter() {
        int n = testArray.length;
        for(int i = 0;i < n;i++) {                                  //! Time Complexity = O(n)
            for(int j = 0;j < n-i-1;j++) {                          //! Time Complexity = O(n)
                if(testArray[j] > testArray[j + 1]) {               
                    int temp = testArray[j];
                    testArray[j] = testArray[j + 1];
                    testArray[j + 1] = temp;
                }
            }
        }
        return testArray;
    }                                                               //! Time Complexity = O(n^2)

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSorter()));
    }
}
