public class MinStack
{

    private Stack<int> st;
    private Stack<int> min;

    public MinStack()
    {
        st = new Stack<int>();
        min = new Stack<int>();
    }

    public void Push(int val)
    {
        st.Push(val);

        if (min.Count > 0)
        {
            if (min.Peek() > val)
            {
                min.Push(val);
            }
            else
            {
                min.Push(min.Peek());
            }
        }
        else
        {
            min.Push(val);
        }
    }

    public void Pop()
    {
        st.Pop();
        min.Pop();
    }

    public int Top()
    {
        return st.Peek();
    }

    public int GetMin()
    {
        return min.Peek();
    }
}
