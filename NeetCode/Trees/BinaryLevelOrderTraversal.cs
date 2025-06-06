/* 
 * Given a binary tree root, return the level order traversal of it as a nested list, 
 * where each sublist contains the values of nodes at a particular level in the tree, 
 * from left to right.
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
 * [Using Backtracking]
 * Goes recursively to the last node in each branch,
 * Keeps track of the level of the node in each recursion,
 * Adds the value to the global variable on each recursion
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
*/
public class SolutionDFS {
    List<List<int>> res = new List<List<int>>();

    public List<List<int>> LevelOrder(TreeNode root) {
        dfs(root, 0);

        return res;
    }

    private void dfs(TreeNode node, int depth)
    {
        if (node == null)
            return;

        if (res.Count == depth)
            res.Add(new List<int>());
        
        res[depth].Add(node.val);
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}

/**
 * Breadth First Search Solution
 *
 * [Using Queue Datastructure]
 * Starts with Enqueueing the root node / or the nodes in that level,
 * Go on dequeueing the nodes of each level till reaching the last node
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
*/
public class SolutionBFS {
    public List<List<int>> LevelOrder(TreeNode root) {
        List<List<int>> res = new List<List<int>>();

        if (root == null)
            return res;

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);

        while(queue.Count > 0)
        {       
            List<int> values = new List<int>();
            for (int i = queue.Count;i > 0; i--)
            {
                TreeNode node = queue.Dequeue();
                if (node != null)
                {
                    values.Add(node.val);
                    queue.Enqueue(node.left);
                    queue.Enqueue(node.right);
                }
            }
            
            if (values.Count > 0)
            {
                res.Add(values);
            }
        }

        return res;
    }
}
