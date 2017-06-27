#include <stdlib.h>

int comp(const void *e1, const void *e2) {
    int f = *(int *)e1, s = *(int *)e2;
    return f > s ? 1 : (f == s ? 0 : -1);
}

/**
 * Return an array of arrays of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int** fourSum(int* nums, int numsSize, int target, int* returnSize) {
    int **ret, size = 0, i, j, l, r, p, s, *m;
    
    ret = malloc(sizeof(int *));
    qsort(nums, numsSize, sizeof(*nums), comp);
    
    for (i = 0; i < numsSize - 3; ++i) {
        if (i == 0 || nums[i] > nums[i - 1]) {
            for (j = i + 1; j < numsSize - 2; ++j) {
                if (j == i + 1 || nums[j] > nums[j - 1]) {
                    s = -nums[i] - nums[j] + target;
                    l = j + 1;
                    r = numsSize - 1;
                    while (l < r) {
                        if (nums[l] + nums[r] < s)
                            ++l;
                        else if (nums[l] + nums[r] > s)
                            --r;
                        else {
                            ret = realloc(ret, (size + 1) * sizeof(int *));
                            m = malloc(4 * sizeof(int));
                            m[0] = nums[i];
                            m[1] = nums[j];
                            m[2] = nums[l];
                            m[3] = nums[r];
                            ret[size++] = m;
                            p = nums[l];
                            while (l < numsSize && nums[l] == p)
                                ++l;
                            p = nums[r];
                            while (r > 0 && nums[r] == p)
                                --r;
                        }
                    }
                }
            }
        }
    }
    
    *returnSize = size;
    return ret;
}
