/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class ReverseLinkedList {
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode dummy(0);
        dummy.next = head;

        ListNode *preM, *pre = &dummy;
        for (int i = 1; i <= n; ++i) {
            if (i == m) preM = pre;

            if (i > m && i <= n) {
                pre->next = head->next;
                head->next = preM->next;
                preM->next = head;
                head = pre; // head has been moved, so pre becomes current
            }

            pre = head;
            head = head->next;
        }

        return dummy.next;
        
    }
};