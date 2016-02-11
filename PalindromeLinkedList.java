/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {
    
    public ListNode reverse(ListNode head){
        
        if(head == null)
            return null;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        
        while(next != null){
            
            curr.next = prev;
            
            prev = curr;
            curr = next;
            next = next.next;
        }
        
        curr.next = prev;
        return curr;
        
    }
    
    public boolean isPalindrome(ListNode head) {
        
        // way 1: traverse it 2 times, first time use a stack, then check if popped off elements are in stack
        // way 2: reverse it, and check if the linkedlist is the same reversed
        // way 3: Find the midpoint, reverse the first half and see if equal to the 2nd half
        
        if(head == null)
            return true;
            
        if(head.next == null)  
            return true;
        
        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = head;
        //ListNode prev = null;
        
        while(fast != null && fast.next != null && slow != null){
           // prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        // odd number of elements
        if(fast != null && fast.next == null)
            slow = slow.next;
            
        
        ListNode reverse = reverse(slow);
        
        while(head != slow && reverse != null){
            if(head.val != reverse.val){
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }
}