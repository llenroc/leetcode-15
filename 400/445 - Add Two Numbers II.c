static struct ListNode *reverse(struct ListNode *head, int *count) {
    struct ListNode *curr = head, *temp, *prev = NULL;
    *count = 1;
    
    while (1) {
        temp = curr->next;
        curr->next = prev;
        
        ++*count;
        
        prev = curr;
        if (temp)
            curr = temp;
        else
            break;
    }
    
    return curr;
}

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *main, *other, **pp, *head;
    int len1, len2, carry = 0, val;
    
    l1 = reverse(l1, &len1);
    l2 = reverse(l2, &len2);
    
    if (len1 >= len2) {
        main = l1;
        other = l2;
    } else {
        main = l2;
        other = l1;
    }
    
    head = main;
    pp = &main;
    while (other) {
        main = *pp;
        val = main->val + other->val + carry;
        
        if (val > 9) {
            main->val = val - 10;
            carry = 1;
        } else {
            main->val = val;
            carry = 0;
        }
        
        other = other->next;
        pp = &main->next;
    }
    
    while (carry) {
        main = *pp;
        
        if (! main) {
            main = (struct ListNode *)malloc(sizeof(struct ListNode));
            main->val = 0;
            main->next = NULL;
            *pp = main;
        }
        
        if (main->val == 9) {
            main->val = 0;
            carry = 1;
        } else {
            main->val++;
            carry = 0;
        }
        
        pp = &main->next;
    }
    
    while (main->next)
        main = main->next;
    
    return reverse(head, &len1);
}
