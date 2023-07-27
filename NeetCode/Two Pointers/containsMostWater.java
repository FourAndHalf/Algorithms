public class ContainsMostWater {

    //* Brute Force Method 
    public static int volumeCalculator(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {                  //! Time Complexity = O(n)
            int first = heights[i];
            int j = heights.length-1;

            while(i < j) {                                          //! Time Complexity = O(n)
                int last = heights[j];
                if(first < last) {
                    int math = first * (j - i);
                    if(maxArea < math) maxArea = math;
                } else {
                    int math = last * (j - i);
                    if(maxArea < math ) maxArea = math;
                }
                j--;
            }
        }

        return maxArea;
    }                                                               //! Total Time Complexity = O(n^2)

    //* Optimized Method
    public static int optimizedVolumeCalculator(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length-1;

        while(left < right) {                                                               //! Time Complexity = O(n)
            int currentArea = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }                                                                                       //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(volumeCalculator(heights));
    }
}