
/**
 * Reverse Polish Notation
 *
 * You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
 * Return the integer that represents the evaluation of the expression.
 * The operands may be integers or the results of other operations.
 * The operators include '+', '-', '*', and '/'.
 * Assume that division between integers always truncates toward zero.
 *
 * Test Case:
 * Input: tokens = ["1","2","+","3","*","4","-"]
 * Output: 5
 * Explanation: ((1 + 2) * 3) - 4 = 5
 * 
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
*/

public class Solution {
    public int EvalRPN(string[] tokens) {
        Stack<int> stack = new Stack<int>();
        int a = 0, b = 0;
        foreach(string c in tokens) {
            switch(c)
            {
                case "+":
                    a = stack.Pop();
                    b = stack.Pop();
                    stack.Push(a+b);
                    break;
                case "-":
                    a = stack.Pop();
                    b = stack.Pop();
                    stack.Push(b-a);
                    break;
                case "*":
                    a = stack.Pop();
                    b = stack.Pop();
                    stack.Push(a*b);
                    break;
                case "/":
                    a = stack.Pop();
                    b = stack.Pop();
                    stack.Push(b/a);
                    break;
                default:
                    stack.Push(Convert.ToInt32(c));
                    break;
            }
        }

        return stack.Pop();
    }
}

