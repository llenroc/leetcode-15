#include <stdlib.h>

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
typedef struct {
    struct ListNode *head;
} Solution;

/** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
Solution* solutionCreate(struct ListNode* head) {
    Solution *ret = (Solution *)malloc(sizeof(Solution));
    ret->head = head;
    return ret;
}

/** Returns a random node's value. */
int solutionGetRandom(Solution* obj) {
    int ret = obj->head->val, i = 2;
    struct ListNode *curr = obj->head->next;
    
    while (curr) {
        if (rand() % i++ == 0)
            ret = curr->val;
        curr = curr->next;
    }
    
    return ret;
}

void solutionFree(Solution* obj) {
    free(obj);
}

/**
 * Your Solution struct will be instantiated and called as such:
 * struct Solution* obj = solutionCreate(head);
 * int param_1 = solutionGetRandom(obj);
 * solutionFree(obj);
 */
 