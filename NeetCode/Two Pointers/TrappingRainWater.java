public class TrappingRainWater {
    public static int trap(int[] height) {
        if(height.length < 2) return 0;

        int left = 0, right = height.length-1;
        int maxLeft = height[left], maxRight = height[right];
        int volume = 0;

        while(left != right) {
            if(maxLeft <= maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                volume += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                volume += maxRight - height[right];
            }
        }

        return volume;
    }
    
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};

        System.out.println(trap(height));
    }
}
