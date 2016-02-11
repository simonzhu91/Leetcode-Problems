/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null)
            return null;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        
        return root;
        
        // TreeNode inverted = new TreeNode(root.val);
        
        // helper(root, inverted);
        
        // return inverted;
    }
    
    public void inverted(TreeNode root, TreeNode inverted){
        // if(root == null){
        //      inverted = null;
        // }
        
        // else{
            
        // }
    }
}