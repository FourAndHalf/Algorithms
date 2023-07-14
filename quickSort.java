//*             Quick Sort             *//

//? Take a pivot element(here we take the last element of array as pivot).
//? Partition the array based on which are lower than pivot and higher than pivot.
//? Recursively do it till a single element is left in every partition.

public class quickSort {

    public static int partition(int[] testArray, int low, int high) {
        int pivot = testArray[high];
        int i = low-1;

        for(int j = low;j < high;j++) {                                             //! Time Complexity = O(n)
            if(testArray[j] < pivot) {
                i++;

                int temp = testArray[i];
                testArray[i] = testArray[j];
                testArray[j] = temp;
            }
        }
        i++;

        int temp = testArray[i];
        testArray[i] = pivot;
        testArray[high] = temp;

        return i;
    }
    public static void QuickSort(int[] testArray, int low, int high) {
        if(low < high) {
            int pidx = partition(testArray, low, high);

            QuickSort(testArray, low, pidx-1);                                      //! Time Complexity = O(log n)
            QuickSort(testArray, pidx+1, high);
        }
    }                                                                               //! Total Time Complexity = O(nlog n)

    public static void main(String[] args) {
        int[] testArray = {23, 45, 12, 67, 89, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 2, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90};

        int n = testArray.length;

        QuickSort(testArray, 0, n-1);
        
        System.out.println("Array");
        for(int i = 0;i < testArray.length;i++) {
            System.out.print(testArray[i] + ", ");
        }
    }
}