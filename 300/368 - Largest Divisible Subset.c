#include <stdlib.h>

static int comp(const void *n1, const void *n2) {
    return *(int *)n1 - *(int *)n2;
}

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* largestDivisibleSubset(int* nums, int numsSize, int* returnSize) {
    int *dp, *next, *ret, i, j, m = 0, mi = -1, count = 0;
    
    ret = (int *)calloc(3 * numsSize, sizeof(int));
    next = ret + numsSize;
    dp = next + numsSize;
    
    qsort(nums, numsSize, sizeof(int), comp);
    
    for (i = numsSize - 1; i >= 0; --i) {
        for (j = i; j < numsSize; ++j) {
            
            if (nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1;
                next[i] = j;

                if (m < dp[i]) {
                    m = dp[i];
                    mi = i;
                }
            }
        }
    }
    
    for (i = 0; i < m; ++i) {
        ret[count++] = nums[mi];
        mi = next[mi];
    }
    
    *returnSize = count;
    return ret;
}
