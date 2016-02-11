/**
 * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
 */
public class BinaryTreePostOrderTraversal {
    
    // iterative solution of post order traversal
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> toRet = new ArrayList<Integer>();
        
        if(root == null)
            return toRet;
        
        Stack<TreeNode> stk = new Stack<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        TreeNode temp = null;
        
        stk.push(root);

        while(!stk.isEmpty()){
            temp = stk.peek();    
            
            if(temp.left != null && !visited.contains(temp.left)){
                stk.push(temp.left);
            }
            else if(temp.right != null && !visited.contains(temp.right)){
                stk.push(temp.right);
            }
            else{
            	//System.out.println("Here");
                toRet.add(temp.val);
                visited.add(temp);
                stk.pop();
            }
        }   
        return toRet;
    }
	
}