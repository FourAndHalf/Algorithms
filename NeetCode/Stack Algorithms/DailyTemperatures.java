import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    //* Brute Force Method
    public static int[] calculateDailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] solution = new int[n];

        for(int current = 0;current < n;current++) {                            //! Time Complexity = O(n)
            int next = current+1;
            while(next < n) {                                                   //! Time Complexity = O(n)
                if(temperatures[current] < temperatures[next]) {
                    solution[current] = next - current;
                    break;
                }
                next++;
            }
        }
        return solution;                                
    }                                                                           //! Total Time Complexity = O(n^2)

    //* Optimized Method
    public static int[] optimizedCalculateDailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] solution = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n;i++) {                                                          //! Time Complexity = O(n)
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {       //! Time Complexity = O(1)
                solution[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return solution;
    }                                                                                       //! Total Time Complexity = O(n)

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(Arrays.toString(calculateDailyTemperatures(temperatures)));
    }
}
