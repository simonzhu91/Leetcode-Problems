/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root);
    }
    
    public int helper(TreeNode root){
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return helper(root.right) + 1;
        if(root.right == null)
            return helper(root.left) + 1;
        else
            return Math.min(helper(root.left), helper(root.right)) + 1;
    }
}