/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        while(temp != null){
            
            if(map.containsKey(temp.val)){
                map.put(temp.val, map.get(temp.val) + 1);
            }else{
                map.put(temp.val, 1);
            }
            
            temp = temp.next;
        }
        
        // dummy listNode to delete in case 1 element
        temp = new ListNode(-1);
        ListNode toRet = temp;
        temp.next = head;
        
        while(temp.next != null){
            if(map.get(temp.next.val) > 1){
                temp.next = temp.next.next;
            }    
            else{
                temp = temp.next;
            }
        }
     
        
        return toRet.next;
    }
}