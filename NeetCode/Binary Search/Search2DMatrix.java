public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int index = searchPotentialRow(matrix, target);        
        if(index != -1) return binarySearchOverRow(index, matrix, target);
        else return false;
    }

    public static int searchPotentialRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;

        while(low <= high) {
            int middle = low + (high - low)/2;
            if(matrix[middle][0] <= target && target <= matrix[middle][matrix[0].length-1]) {
                return middle;
            } else if(target < matrix[middle][0]) {
                high = middle-1;
            } else if(target > matrix[middle][0]) {
                low = middle+1;
            }
        }
        
        return -1;
    }
    public static boolean binarySearchOverRow(int index, int[][] matrix, int target) {
        int low = 0;
        int high = matrix[index].length-1;

        while(low <= high) {
            int middle = low + (high - low)/2;
            if(target == matrix[index][middle]) {
                return true;
            } else if(target < matrix[index][middle]) {
                high = middle-1;
            } else if(target > matrix[index][middle]) {
                low = middle+1;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        // int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        // int target = 3;

        int[][] matrix = {{1, 3}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
}