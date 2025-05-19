
/**
 * Kth Smallest Integer in BST
 *
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.
 * A binary search tree satisfies the following constraints:
 *      The left subtree of every node contains only nodes with keys less than the node's key.
 *      The right subtree of every node contains only nodes with keys greater than the node's key.
 *      Both the left and right subtrees are also binary search trees.
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

/**
 * Depth First Search Solution
 *
 * Go to the lowest value by recursively going through the lowest left side element
 * uses the peculiarity of binary search tree
 *
*/
public class Solution {
    public int KthSmallest(TreeNode root, int k) {
        List<int> arr = new List<int>();
        dfs(root, arr);

        return arr[k-1];
    }

    private void dfs(TreeNode node, List<int> array) {
        if (node == null)
            return;
        
        dfs(node.left, array);
        array.Add(node.val);
        dfs(node.right, array);
    }
}

