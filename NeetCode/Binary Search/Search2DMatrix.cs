public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.Length == 0 || matrix[0].Length == 0) {
            return false;
        } 
    
        int rows = matrix.Length;
        int elements = matrix[0].Length; 

        int row = SearchRow(matrix, target, 0, rows - 1);

        if (row != -1) {
            return SearchElement(matrix[row], target, 0, elements - 1);
        }

        return false;
    }

    protected int SearchRow(int[][] matrix, int target, int rowStart, int rowEnd) {
        while (rowStart <= rowEnd) {
            int mid = rowStart + (rowEnd - rowStart) / 2;
            int cols = matrix[0].Length;

            if (target >= matrix[mid][0] && target <= matrix[mid][cols - 1]) {
                return mid;
            } else if (target < matrix[mid][0]) {
                rowEnd = mid - 1;
            } else {
                rowStart = mid + 1;
            }
        }

        return -1;
    }

    protected bool SearchElement(int[] matrix, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == matrix[mid]) {
                return true;
            } else if (target < matrix[mid]) {
                end = mid - 1;
            } else if (target > matrix[mid]) {
                start = mid + 1;
            }
        }

        return false;
    }
}
