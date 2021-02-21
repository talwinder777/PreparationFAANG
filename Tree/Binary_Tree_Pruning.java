//Leetcode 814
//this question is very similar to the DELETE LEAVES WITH GIVEN VALUE Leetcode 1325
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
    public TreeNode pruneTree(TreeNode root) {
        
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }
        
        //if the current node becomes the leaf node and it has the value == 0 then return null which means the parent of this node would no longer have this node as a child
        if (root.left == null && root.right == null && root.val == 0) {
            
            return null;
        }
        
        return root;
    }
}
