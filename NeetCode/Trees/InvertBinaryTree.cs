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

    /** Solution using basic recursion technique
    *
    *   Time Complexity : O(n)
    *   Space Complexity : O(h)
    *           Best Case (balanced tree) : O(log(n))  
    *           Worst Case (degenerate tree) : O(n)  
    *   
    *   n : Number of Elements, h: Height of the tree
    *   
    */
    public TreeNode InvertTree(TreeNode root)
    {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        InvertTree(root.left);
        InvertTree(root.right);

        return root;
    }

    /** Solution using a queue datastructure for storing the nodes
    *
    *   Time Complexity : O(n)
    *   Space Complexity : O(n)
    *
    */
    public TreeNode InvertTree(TreeNode root)
    {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);

        while (queue.Count > 0)
        {
            TreeNode node = queue.Dequeue();
            TreeNode tmp = new TreeNode();

            tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null)
                queue.Enqueue(node.left);

            if (node.right != null)
                queue.Enqueue(node.right);
        }

        return root;
    }

    /** Implementation of the same algorithm using Stack datastructure
    *
    *   Time Complexity : O(n)
    *   Space Complexity : O(n)
    *
    */
    public TreeNode InvertTree(TreeNode root)
    {
        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.Push(root);

        while (stack.Count > 0)
        {
            TreeNode node = stack.Pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null)
                stack.Push(node.left);

            if (node.right != null)
                stack.Push(node.right);
        }

        return root;
    }
}
