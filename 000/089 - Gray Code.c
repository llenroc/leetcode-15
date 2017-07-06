#include <math.h>

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* grayCode(int n, int* returnSize) {
    int size, *ret, i, j, t = 1;
    
    size = (int)pow(2, n);
    ret = (int *)malloc(size * sizeof(int));
    ret[0] = 0;
    
    for (i = 0; i < n; ++i) {
        for (j = 0; j < t; ++j)
            ret[t + j] = t + ret[t - 1 - j];
        t *= 2;
    }
    
    *returnSize = size;
    return ret;
}
