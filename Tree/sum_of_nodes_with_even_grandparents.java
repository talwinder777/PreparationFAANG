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
//1315
//intution is to keep storing the grandparents and see for the current node if the grandparent was even, if so add the current nodes value
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        return helper(root, 0, map);
    }
    
    public Integer helper(TreeNode root, int cl, HashMap<Integer, Integer> map) {
        
        if (root == null) {
            
            return 0;
        
        }
        
        map.put(cl, root.val);
        
        int sum = 0;
        
        if (cl >= 2 && map.get(cl-2) % 2 == 0) {
            sum += root.val;
        }
        
        int left = helper(root.left, cl + 1, map);
        int right = helper(root.right, cl + 1, map);
        //important line to avoid duplicate levels in the map, also this helps in bactracking
        map.remove(cl);
        return sum + left + right;
    }
}
