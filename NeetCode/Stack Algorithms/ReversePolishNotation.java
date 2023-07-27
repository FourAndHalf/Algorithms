import java.util.Stack;

public class ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();    

        for(String s : tokens) {                                        //! Time Complexity = O(n)
            if(s.matches("-?\\d+")) {
                stack.push(Integer.parseInt(s));
            } else if(s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/') {
                int a = stack.pop();
                int b = stack.pop();
                int res = calc(a, b, s.charAt(0));
                stack.push(res);
            } else {
                throw new IllegalArgumentException("Invalid Input:" + s);
            }
        }

        return stack.pop();
    }                                                                   //! Total Time Complexity = O(n)

    public static int calc(int a, int b, char operator) {
        if(operator == '+') {
            return b+a;
        } else if(operator == '-') {
            return b-a;
        } else if(operator == '*') {
            return b*a;
        } else {
            return b/a;
        }
    }

    public static void main(String[] args) {
        // String[] tokens = {"2", "1", "+", "3", "*"};
        // String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(evalRPN(tokens));
    }   
}
