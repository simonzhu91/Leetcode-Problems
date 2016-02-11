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
 
 /**
  * 1, 2, 3, 4, 5
  * 
  * Result: 1 -> 5 -> 2 -> 4 -> 3
  * 
  * 1, 2, 3 + 4, 5
  * 1, 2, 3 + 5, 4
  * 1, 5, 2, 4, 3
  * 
  * 1, 2
  * 
  */
 
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        // Idea: Break list into 2
        // Reverse the 2nd list
        // Combine them into 1 list
        
        ListNode temp = head;
        ListNode temp2 = head;
        
        while(temp2.next != null && temp2.next.next != null){
            temp = temp.next;
            temp2 = temp2.next.next;
        }
        
        // breaks the linkedlist into 2
        ListNode secondHalf = temp.next;
        temp.next = null;
        
        // reverse the 2nd half
        ListNode reversed = reverse(secondHalf);
        
        head = merge(head, reversed);
    }
    
    public ListNode reverse(ListNode n){
        if(n == null || n.next == null)
            return n;
            
        ListNode prev = null;
        ListNode curr = n;
        ListNode next = n.next;
        
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        
        curr.next = prev;
        return curr;
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        // if(first == null)
        //     return second;
        ListNode first = l1;
        ListNode second = l2;
        
        while(first != null && second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            first.next = second;
            second.next = temp1;
            
            first = temp1;
            second = temp2;
        }
        
        return l1;
    }
}