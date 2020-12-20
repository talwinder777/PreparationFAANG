//Maximum Sum Average Tree 1120
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
    public double maximumAverageSubtree(TreeNode root) {
        
        //if(root == null)
        double[] Average = calculateMaxAvg(root);
        return Average[2];
    }
    
    public double[] calculateMaxAvg(TreeNode root) {
        
        if(root == null) {
            return new double[3];
        }
        
        double current[] = {root.val, 1, 0};
        
        double[] left = calculateMaxAvg(root.left);
        double[] right = calculateMaxAvg(root.right);
        
        double currSum = current[0] + left[0] + right[0];
        double noOfNodes = current[1] + left[1] + right[1];
        
        double currAvg = currSum / noOfNodes;
        
        current[0] = currSum;
        current[1] = noOfNodes;
            
        if(currAvg > left[2] && currAvg > right[2]) {
            current[2] = currAvg;
            //return current;
        }
        else {
            current[2] = left[2] > right[2] ? left[2] : right[2];
        }
        
        return current;
        
    }
}