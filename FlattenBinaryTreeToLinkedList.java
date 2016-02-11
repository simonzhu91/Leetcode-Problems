/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedList {
   private static TreeNode lastVisited = null;

public static void flatten(TreeNode root) {
    if(root == null)
        return;

    TreeNode savedRight = root.right;
    if(lastVisited != null) {
        lastVisited.left = null;
        lastVisited.right = root;
    }
    lastVisited = root;

    flatten(root.left);
    flatten(savedRight);
}   
}