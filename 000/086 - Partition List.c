/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* partition(struct ListNode* head, int x) {
    struct ListNode **lp, **gp, *l_tail = NULL, *g_head = NULL, *curr, *temp;
        
    if (! head)
        return NULL;
    lp = &head;
    gp = &g_head;
    curr = head;
    
    while (curr) {
        if (curr->val < x) {
            *lp = curr;
            lp = &curr->next;
            l_tail = curr;
        } else {
            *gp = curr;
            gp = &curr->next;
        }
        temp = curr->next;
        curr->next = NULL;
        curr = temp;
    }
    if (l_tail)
        l_tail->next = g_head;
    
    return head;
}
