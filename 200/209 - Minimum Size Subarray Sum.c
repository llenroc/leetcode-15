#define min(a, b) ((a) < (b) ? (a) : (b))

int minSubArrayLen(int s, int* nums, int numsSize) {
    int start = 0, end = 0, ret = numsSize + 1, sum = 0;
    
    if (! numsSize)
        return 0;
    
    while (1) {
        if (sum < s) {
            if (end >= numsSize)
                break;
            sum += nums[end++];
        } else {     
            ret = min(ret, end - start);
            sum -= nums[start++];
        }
    }
    
    return ret > numsSize ? 0 : ret;
}
