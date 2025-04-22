/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution
{
    /** Solution by Recursive Depth First Search (DFS)
    *   
    *   Time Complexity : O(n)
    *   Space Complexity : O(h)
    *           Best Case (balanced tree) : O(log(n))  
    *           Worst Case (degenerate tree) : O(n)  
    *   
    *   n : Number of Elements, h: Height of the tree
    *   
    */
    public int MaxDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        int depth = Math.Max(MaxDepth(root.left), MaxDepth(root.right));

        return 1 + depth;
    }

    /** Solution by Iterative Depth First Search (DFS) [Stack]
    *
    *   Time Complexity : O(n)
    *   Space Complexity : O(n)
    *
    */
    public int MaxDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        int res = 0;
        Stack<Tuple<TreeNode, int>> stack = new Stack<Tuple<TreeNode, int>>();
        stack.Push(new Tuple<TreeNode, int>(root, 1));

        while (stack.Count > 0)
        {
            Tuple<TreeNode, int> tuple = stack.Pop();
            TreeNode node = tuple.Item1;
            int depth = tuple.Item2;

            if (node != null)
            {
                res = Math.Max(res, depth);
                stack.Push(new Tuple<TreeNode, int>(node.left, depth + 1));
                stack.Push(new Tuple<TreeNode, int>(node.right, depth + 1));
            }
        }

        return res;
    }

    /** Solution by Breadth First Search (BFS) [Queue]
    *
    *   Time Complexity : O(n)
    *   Space Complexity : O(n)
    *
    */
    public int MaxDepth(TreeNode root)
    {
        Queue<TreeNode> queue = new Queue<TreeNode>();

        if (root != null)
            queue.Enqueue(root);

        int level = 0;

        while (queue.Count > 0)
        {
            int size = queue.Count;
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.Dequeue();

                if (node.left != null)
                    queue.Enqueue(node.left);
                if (node.right != null)
                    queue.Enqueue(node.right);
            }

            level++;
        }

        return level;
    }
}
