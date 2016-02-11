/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> toRet = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null)
            return toRet;
            
        queue.add(root);
        
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> inner = new ArrayList<Integer>();
            
            for(int i = 0; i < count; i++){
                TreeNode n = queue.remove();
                inner.add(n.val);
                
                if(n.left != null)
                    queue.add(n.left);
                if(n.right != null)
                    queue.add(n.right);
            }
            
            toRet.add(new ArrayList<Integer>(inner));
        }
        
        return toRet;
    }
}