#define max(a, b) ((a) > (b) ? (a) : (b))
#define min(a, b) ((a) < (b) ? (a) : (b))

int maxProduct(int* nums, int numsSize) {
    int pos, neg, ret, temp, i;
    
    pos = nums[0];
    neg = pos;
    ret = pos;
    
    for (i = 1; i < numsSize; ++i) {
        temp = pos;
        pos = max(max(pos * nums[i], neg * nums[i]), nums[i]);
        neg = min(min(temp * nums[i], neg * nums[i]), nums[i]);
        ret = max(ret, pos);
    }
    
    return ret;
}
