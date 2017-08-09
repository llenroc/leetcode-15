#include <stdlib.h>

static int comp(const void *pp1, const void *pp2) {
    int *p1 = *(int **)pp1;
    int *p2 = *(int **)pp2;
    
    return p1[0] < p2[0] || (p1[0] == p2[0] && p1[1] > p2[1]);
}

/**
 * Return an array of arrays of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int** reconstructQueue(int** people, int peopleRowSize, int peopleColSize, int* returnSize) {
    int i, j, k, *temp, count;
    
    qsort(people, peopleRowSize, sizeof(int *), &comp);
    
    for (i = 1; i < peopleRowSize; ++i) {
        count = 0;
        
        for (j = 0; j < i; ++j) {
            if (people[i][1] == count) {
                temp = people[i];
                
                for (k = i - 1; k >= j; --k)
                    people[k + 1] = people[k];
                
                people[j] = temp;
                break;
            }
            
            if (people[j][0] >= people[i][0])
                ++count;
        }
    }
    
    *returnSize = peopleRowSize;
    return people;
}
