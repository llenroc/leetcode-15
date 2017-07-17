/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* sortList(struct ListNode* head) {
    struct ListNode *left, *right, fake, *p;

    if (! (head && head->next))
        return head;
    left = head;
    right = head;
    
    while (right->next && right->next->next) {
        left = left->next;
        right = right->next->next;
    }
    
    right = left->next;
    left->next = NULL;
    
    left = sortList(head);
    right = sortList(right);
    
    if (! left)
        return right;
    if (! right)
        return left;
    
    p = &fake;
    while (left && right) {
        if (left->val < right->val) {
            p->next = left;
            left = left->next;
        } else {
            p->next = right;
            right = right->next;
        }
        p = p->next;
    }
    
    if (left)
        p->next = left;
    else if (right)
        p->next = right;
    
    return fake.next;
}
