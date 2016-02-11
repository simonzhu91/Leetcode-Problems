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
public class SortList {
    
    // Solution: Mergesort, Quicksort
    // We want to do a Mergesort on a Linkedlist
    // Idea is to keep splitting the list in half and doing mergesort on each half
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head){
        
        if(head == null)
            return null;
            
        if(head.next == null){
            return head;
        }
        
        ListNode pointer = head;
        ListNode pointer2 = head;
        
        // find midpoint!
        while(pointer2.next != null && pointer2.next.next != null){
            pointer = pointer.next;
            pointer2 = pointer2.next.next;
        }
        
        ListNode temp = pointer.next;
        pointer.next = null;
        
        // keep splitting it in 2 and then merging the 2 parts
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(temp);
        ListNode newList = merge(l1, l2);
        return newList;
    }
    
    // Merges 2 sorted Lists into 1 list
    public ListNode merge(ListNode p1, ListNode p2){
        
        // checks for nulls
        if(p1 == null)
            return p2;
        if(p2 == null)
            return p1;
        
        // Assume p1 always has smallest value
        if(p1.val > p2.val){
            ListNode temp = p1;
            p1 = p2;
            p2 = temp;
        }
        
        // makes 1st node
        ListNode toRet = new ListNode(p1.val);
        ListNode temp = toRet;
        p1 = p1.next;
        
        ListNode temp1 = p1;
        ListNode temp2 = p2;
        
        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                temp.next = new ListNode(temp1.val);
                temp = temp.next;
                temp1 = temp1.next;
            }else{
                temp.next = new ListNode(temp2.val);
                temp = temp.next;
                temp2 = temp2.next;
            }
        }

        while(temp1 != null){
            temp.next = new ListNode(temp1.val);
            temp = temp.next;
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            temp.next = new ListNode(temp2.val);
            temp = temp.next;
            temp2 = temp2.next;
        }
        
        return toRet;
    }
}