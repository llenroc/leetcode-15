/*
 * @lc app=leetcode id=142 lang=c
 *
 * [142] Linked List Cycle II
 *
 * autogenerated using scripts/convert.py
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *detectCycle(struct ListNode *head) {
    struct ListNode *fast = head, *slow = head;
    
    if (! head)
        return NULL;
    
    do {
        if (! (fast->next && fast->next->next))
            return NULL;
        fast = fast->next->next;
        slow = slow->next;
    } while (slow != fast);
    
    slow = head;
    while (slow != fast) {
        slow = slow->next;
        fast = fast->next;
    }
    
    return slow;
}
