import java.util.Arrays;

public class selectionSort {

    private static Integer[] testArray = {23, 45, 12, 67, 89, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 2, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90};

    public static Integer[] selectionSorter() {
        int n = testArray.length;
        for(int i = 0;i < n;i++) {
            for(int j = i+1;j < n;j++) {
                if(testArray[i] > testArray[j]) {
                    int temp = testArray[i];
                    testArray[i] = testArray[j];
                    testArray[j] = temp;
                }
            }
        }
        return testArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSorter()));
    }
}