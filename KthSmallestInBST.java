/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /**
  *   2 
  *  / \
  * 1   3
  * 
  * k = 1;
  */
 
 /**
  * O(n) Runtime, O(log n) Space
  */
  
public class KthSmallestInBST {
    
    Stack<TreeNode> stk = new Stack<TreeNode>();
    
    public int kthSmallest(TreeNode root, int k) {
        TreeNode temp = root;
        int count = k;
        
        while(temp != null){
            stk.push(temp);    
            temp = temp.left;
        }
        
        TreeNode curr = null;
        
        while(!stk.isEmpty() && count != 0){
            curr = stk.pop();
            
            if(curr.right != null){
                TreeNode r = curr.right;
                
                while(r != null){
                    stk.push(r);
                    r = r.left;
                }
            }
            
            count --;
        }
        
        return curr.val;
    }
}