/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode temp = head;
        
        if(head == null)
            return null;
        
        while(temp != null){
            
            RandomListNode dup = new RandomListNode(temp.label);
            map.put(temp, dup);
            
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null){
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            
            temp = temp.next;
        }
        
        return map.get(head);
        
    }
}