/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertingSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        return convert(num, 0, num.length - 1);
    }
    
    public TreeNode convert(int[] arr, int left, int right){
        if(left > right)
            return null;
        
        int mid = (left + right) / 2;
        TreeNode toRet = new TreeNode(arr[mid]);
        toRet.left = convert(arr, left, mid-1);
        toRet.right = convert(arr, mid+1, right);
        return toRet;
    }
}