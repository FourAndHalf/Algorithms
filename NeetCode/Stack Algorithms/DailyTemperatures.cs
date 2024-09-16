public class Solution {
    public int[] DailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.Length];
        Array.Fill(res, 0);
        Stack<Tuple<int, int>> stack = new Stack<Tuple<int, int>>(); 
            
        stack.Push(Tuple.Create(temperatures[0], 0));
        for (int i = 1; i < temperatures.Length; i++) {
            while (stack.Count > 0 && stack.Peek().Item1 < temperatures[i]) {
                res[stack.Peek().Item2] = i - stack.Peek().Item2;
                stack.Pop();
            }

            stack.Push(Tuple.Create(temperatures[i], i));
        }

        return res;
    }
}

