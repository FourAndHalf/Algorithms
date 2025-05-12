//*             Merge Sort             *//

//? Divide and Conquer Approach.
//? Divide elements from array until its divided into single element arrays.
//? All single element arrays are already sorted
//? Now Conquer(merge) the single element arrays with sorting of the incoming elements into a new array.

public class mergeSort{
    public static void conquer(int[] testArray, int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];

        int idx1 = si;
        int idx2 = mid+1;
        int x = 0;

        while(idx1 <= mid && idx2 <= ei) {                                      //! Time Complexity = O(n)
            if(testArray[idx1] <= testArray[idx2]) {
                merged[x++] = testArray[idx1++];
            } else {
                merged[x++] = testArray[idx2++];
            }
        } 
        while(idx1 <= mid) {
            merged[x++] = testArray[idx1++];
        }
        while(idx2 <= ei) {
            merged[x++] = testArray[idx2++];
        }

        for(int i = 0, j = si;i < merged.length;i++, j++) {
            testArray[j] = merged[i];
        }
    }
    public static void divide(int[] testArray, int si, int ei) {
        if(si >= ei) {
            return;
        }

        int mid = si + (ei - si)/2;

        divide(testArray, si, mid);                                             //! Time Complexity = O(log n)
        divide(testArray, mid+1, ei);
        conquer(testArray, si, mid, ei);
    }                                                                           //! Total Time Complexity = O(nlog n)
    
    public static void main(String[] args) {
         int[] testArray = {23, 45, 12, 67, 89, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 2, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90, 2, 45, 67, 32, 12, 65, 78, 90, 34, 56, 78, 90, 34, 56, 78, 90};

        int n = testArray.length;

        divide(testArray, 0, n-1);

        for(int i = 0;i < n-1;i++) {
            System.out.print(testArray[i] + " ");
        }
    }
} 