/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* singleNumber(int* nums, int numsSize, int* returnSize) {
    int *ret, i, temp = 0;
    
    ret = (int *)malloc(2 * sizeof(int));
    memset(ret, 0, 2 * sizeof(int));
    
    for (i = 0; i < numsSize; ++i)
        temp ^= nums[i];
    
    temp &= -temp;
    
    for (i = 0; i < numsSize; ++i) {
        if (temp & nums[i])
            ret[0] ^= nums[i];
        else
            ret[1] ^= nums[i];
    }
    
    *returnSize = 2;
    return ret;
}
