/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(head == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        
            if(slow == fast){
                fast = head;
                
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return slow;
            }
        }
        
        return null;
        
    }
}