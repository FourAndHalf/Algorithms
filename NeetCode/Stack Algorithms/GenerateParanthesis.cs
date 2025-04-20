public class Solution
{
    public void BackTrack(int openN, int closedN, int n, List<string> res, string stack)
    {
        if (openN == closedN && openN == n)
        {
            res.Add(stack);
            return;
        }

        if (openN < n)
        {
            BackTrack(openN + 1, closedN, n, res, stack + '(');
        }

        if (closedN < openN)
        {
            BackTrack(openN, closedN + 1, n, res, stack + ')');
        }
    }

    public List<string> GenerateParenthesis(int n)
    {
        string stack = string.Empty;
        List<string> res = new List<string>();

        BackTrack(0, 0, n, res, stack);

        return res;
    }
}
