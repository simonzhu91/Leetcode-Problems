/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        
        if(root == null)
            return;
        
        Queue<TreeLinkNode> curr = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
        
        curr.add(root);
        
        while(!curr.isEmpty()){
            TreeLinkNode temp = curr.remove();
            
            if(curr.isEmpty()){
                temp.next = null;
            }else{
                temp.next = curr.element();
            }
            
            if(temp.left != null){
                next.add(temp.left);
            }
            if(temp.right != null){
                next.add(temp.right);
            }
            
            // swaps curr and next if curr is empty
            if(curr.isEmpty()){
                curr = next;
                next = new LinkedList<TreeLinkNode>();
            }
        }
    }
}