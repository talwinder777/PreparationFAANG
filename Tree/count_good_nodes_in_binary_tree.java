//1448
//Since the current node can be a good node if and only is all the node in its path from root are smaller than it. So we can keep on passing the max of all the nodes in the path of the current node and then see if the curr node is the good node or not.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        
       return calNodes(root, root.val);
    }
    
    public int calNodes(TreeNode root, int max) {
        
        if (root == null) {
            return 0;
        }
        
        int res = 0;
        if (root.val >= max) {
            res += 1;
        }
        
        res += calNodes(root.left, Math.max(root.val, max));
        res += calNodes(root.right, Math.max(root.val, max));
        
        return res;
    }
}
