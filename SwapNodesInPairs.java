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
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        
        ListNode prev, curr, next;
        
        // if 0 or 1 elements
        if(head == null || head.next == null)
            return head;
            
            
        prev = head;
        curr = head.next;
        next = head.next.next;
        
        head = head.next;
        
        while(next != null){
            curr.next = prev;
            
            //prev's next to skip over by 2 if exists
            if(next.next != null)
                prev.next = next.next;
            else{
                prev.next = next;
            }
            
            if(next.next != null){
                prev = next;
                curr = next.next;
                next = next.next.next;
            } else {
                break;
            }
        }
        
        //swap last pair
        curr.next = prev;
        prev.next = next;
        
        return head;
    }
}