/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountCompleteTreeNodes {
    
    // If root is null: return 0
    // return 1 + countNodes(root.left) + countNodes(root.right)
    // O(n)
    
    // can we do better?
    // O(log n) <- average case
    // count number of levels
    // traverse to the 2nd the last level: # of nodes: 2^n
    // for each node in the last level: count their children and add to result
    
    // gets height of a full binary tree
    public int getHeight(TreeNode n){
        if(n == null)
            return 0;
        return 1 + getHeight(n.left);
    }
    
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = getHeight(root.left);
        // System.out.println(left);
        int right = getHeight(root.right);
        // System.out.println(right);
        
        int left_count = (1 << left) - 1;
        int right_count = (1 << right) - 1;
        int whole_count = (1 << (left + 1)) - 1;
        // System.out.println((1 << 3) - 1);
        if(left == right){
            return left_count + 1 + countNodes(root.right);
        }
        
        else{
            return right_count + 1 + countNodes(root.left);
        }
    }
}