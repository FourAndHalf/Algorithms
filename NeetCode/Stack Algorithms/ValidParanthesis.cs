public class Solution {
    public bool IsValid(string s) {
        Stack<char> valStack = new Stack<char>();
        Dictionary<char, char> closeToOpen = new Dictionary<char, char> {
            { ')', '('},
            { ']', '['},
            { '}', '{'}
        };

        foreach (char c in s)
        {
            if (closeToOpen.ContainsKey(c))
            {
                if (valStack.Count > 0 && valStack.Peek() == closeToOpen[c])
                {
                    valStack.Pop();
                }
                else 
                {
                    return false;
                }
            }
            else 
            {
                valStack.Push(c);
            }
        }

        return valStack.Count == 0;        
    }
}
