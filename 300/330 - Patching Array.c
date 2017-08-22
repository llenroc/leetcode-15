int minPatches(int* nums, int numsSize, int n) {
    long long miss = 1;
    int i = 0, ret = 0;
    
    while (miss <= n) {
        if (i < numsSize && nums[i] <= miss)
            miss += nums[i++];
        else {
            miss *= 2;
            ret++;
        }
    }
    
    return ret;
}