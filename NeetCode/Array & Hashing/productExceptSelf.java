import java.util.Arrays;
import java.util.HashMap;

public class productExceptSelf {

    //* Brute Force Method
    public static int[] productExceptSelfFinder(int[] nums) {
        int[] productArray = new int[nums.length];
        Arrays.fill(productArray, 1);
        
        for (int i = 0;i < nums.length;i++) {                                   //! Time Complexity = O(n)
            for (int j = 0; j < productArray.length; j++) {                     //! Time Complexity = O(n)
                if(i != j){
                    productArray[i] = productArray[i] * nums[j];
                }
            }
        }

        return productArray;
    }                                                                           //! Total Time Complexity = O(n^2)

    //* Another Brute Force Method 
    public static int[] productExceptSelfFinderII(int[] nums) {
        int[] productArray = new int[nums.length];
        int product = 1;

        for(int i = 0;i < nums.length;i++) {                                    //! Time Complexity = O(n)
            if(nums[i] != 0) {
                product = product * nums[i];
            }
        }
        Arrays.fill(productArray, product);

        boolean containsZero = false;
        for(int i = 0;i < productArray.length;i++) {                            //! Time Complexity = O(n)
            if(nums[i] == 0) {
                containsZero = true;
                break;
            }
        }

        for(int i = 0;i < nums.length;i++) {                                    //! Time Complexity = O(n)
            if(containsZero && nums[i] != 0) {
                productArray[i] = 0;
            }

            if(!containsZero) {
                productArray[i] = productArray[i] / nums[i];
            }
        }

        return productArray;                                                    
    }                                                                           //! Total Time Complexity = O(n)

    //* Optimized Solution
    public static int[] optimizedProductExceptSelfFinder(int[] nums) {
        int n = nums.length;
        int[] productArray = new int[n];
        Arrays.fill(productArray, 1);
        int curr = 1;

        for(int i = 0;i < n;i++) {                                              //! Time Complexity = O(n)
            productArray[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n-1;i >= 0;i--) {                                           //! Time Complexity = O(n)
            productArray[i] *= curr;
            curr *= nums[i];
        }

        return productArray;
    }                                                                           //! Total Time Complexity = O(n)
    
    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};

        System.out.println(Arrays.toString(optimizedProductExceptSelfFinder(nums)));
    }
}