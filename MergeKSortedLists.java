/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> q = new PriorityQueue<ListNode>(new ListComparator());
        for(ListNode n: lists){
            if( n!= null) {
                q.add(n);
            }
        }
        ListNode head = new ListNode(0), p = head, cur = null;
        while( !q.isEmpty()) {
            cur = q.poll();
            if(cur.next!=null)
                q.offer(cur.next);
            p.next = cur;
            p = p.next;
        }
        return head.next;
    }
}

class ListComparator implements Comparator<ListNode>{

    @Override
    public int compare(ListNode n1, ListNode n2) {
        return n1.val - n2.val;
    }
}