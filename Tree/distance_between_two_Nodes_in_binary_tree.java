//1740
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
    
    TreeNode LcaNode = null;
    boolean isFound = false;
    int leftDist = 0, rightDist = 0; 
    public int findDistance(TreeNode root, int p, int q) {
        
        findLca (root, p , q);
        //last parameter tells to record the distance for which node left or right
        findDist (LcaNode, p, 0, 0);
        
        isFound = false;
        
        findDist (LcaNode, q, 0, 1);
        
        return leftDist + rightDist;
    }
    
    public void findDist(TreeNode root, int target, int level, int mode) {
        
        if (root == null || isFound == true) return;
        
        
        if (root.val == target) {
            isFound = true;
            if (mode == 0) {
                leftDist = level;
            }
            else
                rightDist = level;
            return;
        }
        
        findDist(root.left, target, level + 1, mode);
        findDist(root.right, target, level + 1, mode);
    }
    
    public TreeNode findLca(TreeNode root, int p, int q) {
        
        if (root == null) {
            return null;
        }
        
        if (root.val == p || root.val == q) {
            
            LcaNode = root;
            return root;
        }
        
        TreeNode left = findLca (root.left, p, q);
        TreeNode right = findLca (root.right, p, q);
        
        //not found either on left side nor on right side
        if (left == null && right == null) {
            return null;
        }
        //found one left side and other on right side so the lca would be the current root
        if (left != null && right != null) {
            
            LcaNode = root;
            
        }
        //reaches on if one of the side and other side is null. Happens if both of them occurs on same side. global LcaNode is set to the node which was found in current nodes left or right call. 
        return root;
    }
}

/*
Better implementation

class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        if (p == q)
            return 0;
        TreeNode lca = LCA(root, p, q);
        return dist(p, lca, 0) + dist(q, lca, 0);
    }
    private int dist(int target, TreeNode node, int travel) {
        if (node == null)
            return -1;
        if (target == node.val)
            return travel;
        int travelLeft = dist(target, node.left, travel + 1);
        if (travelLeft == -1)
            return dist(target, node.right, travel + 1);
        return travelLeft;
        
    }
    private TreeNode LCA(TreeNode root, int p, int q) {
        if (root == null)
            return null;
        if (root.val == p || root.val == q)
            return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }
}
*/
