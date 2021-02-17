/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    
   
    // define your fields here
    
};


class TreeNode extends Node {
    String val;
    TreeNode left;
    TreeNode right;
    
    HashSet<String> hs = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    public TreeNode(String val){
        this.val = val;
    } 
    @Override
    public int evaluate() {
        if(!hs.contains(this.val)) {
            return Integer.valueOf(this.val);
        }
        if(this.val.equals("+"))
            return left.evaluate() + right.evaluate();
        if(this.val.equals("-"))
            return left.evaluate() - right.evaluate();
        if(this.val.equals("*"))
            return left.evaluate() * right.evaluate();
        else
            return left.evaluate() / right.evaluate();
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<TreeNode> st = new Stack<>();
        HashSet<String> hs = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        int i = 0;
        while(i < postfix.length) {
            
            if (!hs.contains(postfix[i])) {
                TreeNode node = new TreeNode(postfix[i]);
                st.push(node);
            }
            else {
                TreeNode node = new TreeNode(postfix[i]);
                node.right = st.pop();
                node.left = st.pop();
                st.push(node);
            }
            i++;
        }
        // System.out.println("size = "+st.size());
        return st.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
