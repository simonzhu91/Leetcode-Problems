/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        
        while(curr != null){
            
            if(curr.val == val && prev != null){
                
                prev.next = curr.next;
                
                ListNode temp = curr.next;
                curr.next = null;
                curr = temp; 
                
                if(next != null)
                    next = next.next;
            }
            
            else{
                
                if(curr.val == val && prev == null){
                    head = head.next;
                    curr = curr.next;
                    if(next != null)
                        next = next.next;
                    
                }
                else{
                    prev = curr;
                    curr = curr.next;
                    if(next != null)
                        next = next.next;
                }
            }        
        }
        
        return head;
    }
}