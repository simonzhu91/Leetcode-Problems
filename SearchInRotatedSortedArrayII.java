/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SearchInRotatedSortedArrayII {
    public int sumNumbers(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return helper(root, 0);
    }
    
    public int helper(TreeNode root, int currSum){
        if(root == null)
            return 0;
        
        currSum = currSum * 10;
        currSum += root.val;
        
        if(root.left == null && root.right == null)
            return currSum;
        
        int sum = 0;
        int sum2 = 0;
        
        if(root.left != null)
            sum = helper(root.left, currSum);
        
        if(root.right != null)
            sum2 = helper(root.right, currSum);
        
        return sum + sum2;    
        
        }
    
}