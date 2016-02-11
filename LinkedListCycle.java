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
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(head == null || head.next == null)
            return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        // while neither is null, move both pointers
        while(slow != null && fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                return true;
        }
        
            return false;
    }
}