
/**
 * Valid Binary Search Tree
 *
 * Given the root of a binary tree, return true if it is a valid binary search tree, otherwise return false.
 * A valid binary search tree satisfies the following constraints:
 *
 * The left subtree of every node contains only nodes with keys less than the node's key.
 * The right subtree of every node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees are also binary search trees.
 *
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
*/


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

public class Solution {
    public bool IsValidBST(TreeNode root) {
        return isValid(root, long.MinValue, long.MaxValue);
    }

    private bool isValid(TreeNode node, long left, long right) {
        if (node == null)
            return true;
        
        if (!(left < node.val && node.val < right)) 
            return false;
        
        return isValid(node.left, left, node.val) && isValid(node.right, node.val, right);
    }
}
