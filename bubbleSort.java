//*             Bubble Sort             *//

//? Loops (n-1) times takes the largest element every time and keeps it at the end.

import java.util.Arrays;

public class bubbleSort {
    
    private static Integer[] testArray = {23, 45, 12, 67, 89, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 2, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90};

    private static Integer[] bubbleSorter() {
        int n = testArray.length;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n-1;j++) {
                if(testArray[j] > testArray[j + 1]) {
                    int temp = testArray[j];
                    testArray[j] = testArray[j + 1];
                    testArray[j + 1] = temp;
                }
            }
        }
        return testArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSorter()));
    }
}
