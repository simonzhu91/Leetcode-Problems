/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        
        ArrayList<String> paths = new ArrayList<String>();
        
        if(root == null)
            return paths;
        
        helper(root, paths, ""+root.val);
        
        return paths;
    }
    
    
    public void helper(TreeNode node, List<String> paths, String currPath){
        if(node.left == null && node.right == null){
            paths.add(currPath);
            return;
        }
        
        else if(node.left == null){
            helper(node.right, paths, currPath + "->" + node.right.val);
        }
        
        else if(node.right == null){
            helper(node.left, paths, currPath + "->" + node.left.val);
        }
        
        // if there are 2 possible paths
        else{
            
            helper(node.left, paths, currPath + "->" + node.left.val);
            
            helper(node.right, paths, currPath + "->" + node.right.val);
        }
        
    }
}