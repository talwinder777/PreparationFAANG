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

//There are other solutions also, refer leetcode
//1008
class Solution {
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        
        int lower = Integer.MIN_VALUE;
        int upper = Integer.MAX_VALUE;
        return helper (lower, upper, preorder);
    }
    
    public TreeNode helper(int lower, int upper,int[] preorder) {
        
        if (idx == preorder.length) {
            return null;
        }
        
        if (preorder[idx] < lower || preorder[idx] > upper) {
            return null;
        }
        
        int val = preorder[idx];
        TreeNode root = new TreeNode(preorder[idx++]);
        
        root.left = helper(lower, val, preorder);
        root.right = helper(val, upper,preorder);
        return root;
    }
}
