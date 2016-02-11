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
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
       
       if(head == null)
            return null;
       
        ListNode temp = head;
        ListNode less = null;
        ListNode lessTemp = less;
        ListNode more = null;
        ListNode moreTemp = more;
        
        while(temp != null){
            
            if(temp.val < x){
                if(less ==  null){
                    less = new ListNode(temp.val);
                    lessTemp = less;
                }else{
                    lessTemp.next = new ListNode(temp.val);
                    lessTemp = lessTemp.next;
                }
            }else{
                if(more ==  null){
                    more = new ListNode(temp.val);
                    moreTemp = more;
                }else{
                    moreTemp.next = new ListNode(temp.val);
                    moreTemp = moreTemp.next;
                }
            }
            
            temp = temp.next;
        }
        
        if(lessTemp != null){
            lessTemp.next = more;
        }else{
            return more;
        }
        return less;
    }
}