/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    public boolean helper(TreeNode root, int max, int min){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max){
            return false;
        }
        
        return helper(root.left, root.val, min) && helper(root.right, max, root.val); 
    }
}