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

/** Solved using a global variable to save the diameter value
    The DFS function called recursively is used to find the maximum height of the node.

    Time Complexity : O(n)
    Space Complexity : O(n)

*/
public class Solution
{
    int res = 0;
    public int DiameterOfBinaryTree(TreeNode root)
    {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node)
    {
        if (node == null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        res = Math.Max(res, left + right);

        return 1 + Math.Max(left, right);
    }
}
