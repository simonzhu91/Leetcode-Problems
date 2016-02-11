/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> toRet = new ArrayList<ArrayList<Integer>>();
        helper(root, sum, 0, path, toRet);
        
        return toRet;
    }
    
    public void helper(TreeNode n, int sum, int currSum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> toRet){
        
        if(n == null){
            return;
        }
   
        else{
            
            if(n.left != null && n.right != null){
                
                ArrayList<Integer> right = new ArrayList<Integer>();
                path.add(n.val);
                right.addAll(path);
                helper(n.left, sum, currSum + n.val, path, toRet);
                helper(n.right, sum, currSum + n.val, right, toRet);
            }
            
            else if(n.right != null){
                path.add(n.val);
                helper(n.right, sum, currSum + n.val, path, toRet);
            }
            
            else if(n.left != null){
                path.add(n.val);
                helper(n.left, sum, currSum + n.val, path, toRet);
            }
            
            // leaf since both are null
            else if(currSum + n.val == sum){
                 path.add(n.val);
                 toRet.add(path);
            }
            
        }
        
    }
}