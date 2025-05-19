
/**
 * Count Good Nodes in Binary Tree
 *
 * Within a binary tree, a node x is considered good if the path from the root of the tree 
 * to the node x contains no nodes with a value greater than the value of node xGiven
 *
 * Given the root of a binary tree root, return the number of good nodes within the tree.
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

/**
 * Takes a value as the highest value in the node, 
 * Go recursively to the element at the lowest level in the branch
 * Increase the count of elements on checking if the value is greater then the already shown maxValue
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
*/
public class Solution {    
    public int GoodNodes(TreeNode root) {
        int val = count(root, int.MinValue);

        return val;
    }

    private int count(TreeNode node, int maxValue) {
        if (node == null)
            return 0;
        
        int res = (node.val >= maxValue) ? 1 : 0;
        res += count(node.left, Math.Max(maxValue, node.val));
        res += count(node.right, Math.Max(maxValue, node.val));

        return res;
    }
}

