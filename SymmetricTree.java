/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    /*
  private ArrayList<Integer> alist = new ArrayList<Integer>();
  
    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.

        
        inOrder(root);
        
        return isPalindrome(alist);
        
    }
    
    public void inOrder(TreeNode n){
        
        if(n.left != null){
            inOrder(n.left);
        }
        
        //visit n
        alist.add(n.val);
        //System.out.println(n.val);
       
        if(n.right != null)
            inOrder(n.right);
    }
    
    public boolean isPalindrome(ArrayList<Integer> array){
        Stack<Integer> stk = new Stack<Integer>();
	    int i = 0;

        for(; i<array.size()/2; i++){
            stk.push(array.get(i));
        }
        
        if(array.size() % 2 == 1)
            i++;
        
        for(; i < array.size(); i++){
            
            if(stk.isEmpty())
                return false;
            
            if(stk.pop() != array.get(i))
                return false;
        }
        return true;
    }*/
    
    public boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }

    return helper(root.left, root.right);
}

private boolean helper(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null || b == null) return false;
    if (a.val != b.val) return false;
    return helper(a.left, b.right) && helper(a.right, b.left);
}
}