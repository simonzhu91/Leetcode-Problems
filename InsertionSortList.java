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
 
public class InsertionSortList {
    
    
    /**
     * Algorithm: for each element that we add on to insertionSort, we:
     * remove the element
     * add it to the front
     * and swap it down the list if A[j] > A[j+1]
     * 
     * 5 -> 3 -> 4 -> 1 -> 2 =
     * 3 -> 5 -> 4 -> 1 -> 2 =
     * 3 -> 4 -> 5 -> 1 -> 2 =
     * 
     * 
     */
    // only have to swap values in the LinkedLists
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
            
        if(head.next == null)
            return head;
            
        ListNode curr = head.next;
        ListNode prev = head;
        ListNode runner;
        
        while(curr!=null){
        
            // removes the element
            prev.next = curr.next;
            curr.next = head;
            head = curr;
            runner = curr;
        
            while(runner != prev){
                
                // compare each node with its neighbor, swap if necessary
                if(runner.val > runner.next.val){
                    int temp = runner.val;
                    runner.val = runner.next.val;
                    runner.next.val = temp;
                }
                runner = runner.next;
            }    
            
            curr = prev.next;
        }
        
        return head;
    }
}