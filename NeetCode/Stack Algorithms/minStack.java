import java.util.ArrayList;
import java.util.LinkedList;

public class minStack {

    //* Brute Force Method
    static class MinStack {
        ArrayList<Integer> stack;
        int top;

        public void MinimumStack() {
            stack = new ArrayList<>();
            top = -1;
        }
        public void push(int val) {
            stack.add(val);
            top++;
        }
        public void pop() {
            stack.remove(top);
            top--;
        }
        public int top() {
            return stack.get(top);
        }
        public int getMin() {
            int min;

            if(stack.isEmpty()) {
                return -1;
            } else {
                min = stack.get(0);
                for(int i = 1;i < stack.size();i++) {               //! Time Complexity = O(n)
                    if(min > stack.get(i)) {
                        min = stack.get(i);
                    }
                }
            }

            return min;
        }
    }                                                               //! Total Time Complexity = O(n)

    //* Optimized Method
    static class optimizedMinStack {
        LinkedList<TplusMin> stack;

        private class TplusMin {
            int val;
            int min; 
            public TplusMin(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        public void MinStack() {
            stack = new LinkedList<>();
        }
        public void push(int val) {
            int newMin;
            if(stack.size() == 0) {
                newMin = val;
            } else {
                int currentMin = stack.getFirst().min;
                newMin = currentMin < val ? val : currentMin;
            }

            stack.addFirst(new TplusMin(val, newMin));
        }
        public void pop() {
            stack.removeFirst();
        }
        public int top() {
            return stack.getFirst().val;
        }
        public int getMin() {
            return stack.getFirst().min;
        }
    }                                                                   //! Total Time Complexity = O(1)

    public static void main(String[] args) {
        optimizedMinStack minStack = new optimizedMinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); 
        minStack.pop();
        minStack.top();    
        minStack.getMin(); 
    }
}
