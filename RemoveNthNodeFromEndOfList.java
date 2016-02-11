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
public class RemoveNthNodeFromEndofList {
    
    ListNode temp = null;
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int v = nthFromEnd(head, n+1);
        
        if(temp == null)
        head = head.next;
        else
        temp.next = temp.next.next;
        
        return head;
    }
    
    public int nthFromEnd(ListNode head, int n){
        if(head == null){
            return 0;
        }
        
      int num = nthFromEnd(head.next, n) +1;
      
      if ( num == n){
          temp = head;
      }
            
    return num;
    }
}