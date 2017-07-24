int singleNumber(int* nums, int numsSize) {
    int ret = 0, i, j, mask, sum;
    
    for (i = sizeof(int) * 8 - 1; i >= 0; --i) {
        mask = 1 << i;
        sum = 0;
        for (j = 0; j < numsSize; ++j) {
            if (nums[j] & mask)
                ++sum;
        }
        ret = (ret << 1) + (sum % 3);
    }
    
    return ret;
}