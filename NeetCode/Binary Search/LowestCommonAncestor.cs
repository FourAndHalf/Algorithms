
/**
 * Lowest Common Ancestor in Binary Search Tree
 *
 * Given a binary search tree (BST) where all node values are unique, 
 * and two nodes from the tree p and q, return the lowest common ancestor (LCA) of the two nodes.
 * The lowest common ancestor between two nodes p and q is the lowest node in a tree T 
 * such that both p and q as descendants. The ancestor is allowed to be a descendant of itself.
 *
 * Test Cases:
 *      Input: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 8
 *      Output: 5
 *
 * Time Complexity: O(h)    h: Height of given tree
 * Space Complexity: O(h)
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
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = new TreeNode();
        if (p.val < q.val)
        {
            res = Ancestor(root, p, q);
        }
        else 
        {
            res = Ancestor(root, q, p);
        }
            
        return res;
    }

    private TreeNode Ancestor(TreeNode node, TreeNode p, TreeNode q) {
        if ((p.val <= node.val) && (node.val <= q.val))
        {
            return node;
        }
        else if (node.val < p.val)
        {
            return Ancestor(node.right, p, q);
        }
        else 
        {
            return Ancestor(node.left, p, q);
        }
    }
}

