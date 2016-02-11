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
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null)
            return null;
            
        if(l1 == null)
            return l2;
        
        if(l2 == null)
            return l1;
        
        // guranteed that there are at least 1 element in both lists
        
        ListNode t1 = l1;
        ListNode t2 = l2;
        
        int carry = 0;
        
        ListNode t3 = new ListNode((l1.val + l2.val) % 10);
        carry = (l1.val + l2.val) / 10;
        
        ListNode temp = t3;
        
        t1 = t1.next;
        t2 = t2.next;
        
        while(t1 != null && t2 != null){
            
            temp.next = new ListNode((t1.val + t2.val + carry) % 10);
            carry = (t1.val + t2.val + carry) / 10;
            
            temp = temp.next;
            t1 = t1.next;
            t2 = t2.next;
        }
        
        while(t1 != null){
            temp.next = new ListNode((t1.val + carry) % 10);
            carry = (t1.val + carry) / 10;
            
            temp = temp.next;
            t1 = t1.next;
        }
        
        while(t2 != null){
            temp.next = new ListNode((t2.val + carry) % 10);
            carry = (t2.val + carry) / 10;
            
            temp = temp.next;
            t2 = t2.next;
        }
        
         
        if(carry != 0){
            temp.next = new ListNode(carry);
            temp = temp.next;
        }
        
        temp.next = null;
        
        return t3;
    }
}