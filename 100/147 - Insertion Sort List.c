#include <limits.h>

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* insertionSortList(struct ListNode* head) {
    struct ListNode new_head, *curr, *p;
    
    new_head.val = INT_MIN;
    new_head.next = NULL;
    
    while (head) {
        curr = head;
        p = &new_head;
        head = head->next;
        
        while (p->next && p->next->val <= curr->val) 
            p = p->next;
        
        curr->next = p->next;
        p->next = curr;
    }
    
    return new_head.next;
}
