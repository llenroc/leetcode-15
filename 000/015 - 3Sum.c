#include <stdlib.h>

int comp(const void *e1, const void *e2) {
    int f = *((int *)e1), s = *((int *)e2);
    return f > s ? 1 : (f == s ? 0 : -1);
}

/**
 * Return an array of arrays of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int** threeSum(int* nums, int numsSize, int* returnSize) {
    int i, tar, l, r, p, **ret = malloc(sizeof(int)), *m, j = 0, s = 0;
    
    qsort(nums, numsSize, sizeof(*nums), comp);
    for (i = 0; i < numsSize; ++i) {
        if (i == 0 || nums[i] > nums[i - 1]) {
            tar = -nums[i];
            l = i + 1;
            r = numsSize - 1;
            while (l < r) {
                if (nums[l] + nums[r] > tar)
                    --r;
                else if (nums[l] + nums[r] < tar)
                    ++l;
                else {
                    m = (int *)malloc(3 * sizeof(int));
                    m[0] = nums[i];
                    m[1] = nums[l];
                    m[2] = nums[r];
                    ret = (int **)realloc(ret, (s + 1) * sizeof(int *));
                    ret[s++] = m;
                    p = nums[l];
                    while (nums[l] == p && l < numsSize)
                        ++l;
                    p = nums[r];
                    while (nums[r] == p && r > 0)
                        --r;
                }
            }
        }
    }
    *returnSize = s;
    return ret;
}
