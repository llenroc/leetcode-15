int totalHammingDistance(int* nums, int numsSize) {
    int bits = sizeof(int) * 8, i, j, curr, count, ret = 0;
    
    for (i = 0; i < bits; ++i) {
        curr = 1 << i;
        count = 0;
        
        for (j = 0; j < numsSize; ++j) {
            if (curr & nums[j])
                ++count;
        }
        
        ret += count * (numsSize - count);
    }
    
    return ret;
}
