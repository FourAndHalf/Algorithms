
/*
 * Same Binary Tree
 *
 * Given the roots of two binary trees p and q, return true if the trees are equivalent, otherwise return false.
 * Two binary trees are considered equivalent if they share the exact same structure and the nodes have the same values.
 *
 * Test Case
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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
    public bool IsSameTree(TreeNode p, TreeNode q) {
        if ((p != null && q == null) || (p == null && q != null))
            return false;
        
        if (p == null && q == null)
            return true;

        if (p.val == q.val)
        {
            if (!IsSameTree(p.left, q.left))
                return false;
            if (!IsSameTree(p.right, q.right))
                return false;
        }
        else 
        {
            return false;
        }

        return true;
    }
}

