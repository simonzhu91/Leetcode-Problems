/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePreOrderTraversal {
     public ArrayList<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> alist = new ArrayList<Integer>();

        if(root == null)
            return alist;

        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.add(root);
        
        while(!stk.isEmpty()){
            TreeNode temp = stk.pop();
            int val = temp.val;

            if(temp.right != null){
                stk.add(temp.right);
            }

            alist.add(val);
            
            if(temp.left != null){
                stk.add(temp.left);
            }
        }
        
        return alist; 
    }
}