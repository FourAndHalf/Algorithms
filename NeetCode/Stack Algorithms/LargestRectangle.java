import java.util.Stack;

public class LargestRectangle {
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0;i < heights.length;i++) {
            while(!stk.empty() && (i == heights.length || heights[stk.peek()]>=heights[i])) {
                int index = stk.pop();

                int left = stk.empty() ? 0 : stk.peek()+1;
                maxArea = Math.max(maxArea, heights[index]*(i-1 - left+1));
            }
            stk.push(i);
        }

        return maxArea;
    }                                                           //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(largestRectangleArea(heights));
    }
}