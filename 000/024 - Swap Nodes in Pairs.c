/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    struct ListNode *f = head, *s, *t, **pp = &head;
    while (f) {
        s = f->next;
        if (s) {
            *pp = s;
            t = s->next;
            s->next = f;
            f->next = t;
            pp = &f->next;
            f = t;
        } else
            break;
    }
    return head;
}
