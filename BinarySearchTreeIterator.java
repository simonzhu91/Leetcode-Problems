/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinarySearchTreeIterator {

    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        
        if(root == null){
            return;
        }
        else{
            stack.push(root);
            
            TreeNode temp = root;
            while(temp.left != null){
                stack.push(temp.left);
                temp = temp.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        
        if(!hasNext()){
            return -1;
        }
        
        TreeNode n = stack.pop();
        TreeNode temp = n.right;
        
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        
        return n.val;
        
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */