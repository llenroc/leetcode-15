#include <stdlib.h>
#include <string.h>

static int comp(const void *p1, const void *p2) {
    return *(int *)p1 - *(int *)p2;
}

int findUnsortedSubarray(int* nums, int numsSize) {
    int *copy, i, j;
    
    if (! numsSize)
        return 0;
    
    copy = (int *)malloc(numsSize * sizeof(int));
    memcpy(copy, nums, numsSize * sizeof(int));
    qsort(nums, numsSize, sizeof(int), &comp);
    
    i = 0;
    j = numsSize - 1;
    while (i < numsSize && nums[i] == copy[i])
        ++i;
    while (j > i && nums[j] == copy[j])
        --j;
    
    free(copy);
    
    return j - i + 1;
}
