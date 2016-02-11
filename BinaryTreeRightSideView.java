/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> toRet = new ArrayList<Integer>();
        
        if(root == null)
            return toRet;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int count = queue.size();
            
            for(int i = 0; i < count; i++){
                
                TreeNode n = queue.remove();
                
                // process n
                if(i == count-1){
                    toRet.add(n.val);
                }
                
                if(n.left != null){
                    queue.add(n.left);
                }
                
                if(n.right != null){
                    queue.add(n.right);
                }
            }
        }
        
        return toRet;
    }
}