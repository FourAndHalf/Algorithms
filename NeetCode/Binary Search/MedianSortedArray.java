public class MedianSortedArray {
    public static double findMedian(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = total/2;
        int[] A = nums1;
        int[] B = nums2;        

        if(B.length < A.length) {
            A = B;
            B = nums1;
        }

        int left = 0;
        int right = A.length-1;
        
        while (true) {
            int i = (left + right)/2;
            int j = half - i - 2;
            int ALeft = 0;
            int ARight = 0;
            int BLeft = 0;
            int BRight = 0;

            if(i >= 0) {
                ALeft = A[i];
            } else {
                ALeft = Integer.MIN_VALUE;
            }

            if(i+1 < A.length) {
                ARight = A[i+1];
            } else {
                ARight = Integer.MAX_VALUE;
            }

            if(j >= 0) {
                BLeft = A[j];
            } else {
                BLeft = Integer.MIN_VALUE;
            }

            if(j+1 < A.length) {
                BRight = A[j+1];
            } else {
                BRight = Integer.MAX_VALUE;
            }

            if(ALeft <= BRight && BLeft <= ARight) {
                if(total%2 != 0) {
                    return (double)Math.min(ARight, BRight);
                }

                return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight))/2.0;
            } else if(ALeft > BRight) {
                right = i-1;
            } else {
                left = i+1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(findMedian(nums1, nums2));
    }
}
