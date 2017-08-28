#include <stdlib.h>

static int comp(const void *p1, const void *p2) {
    return *(int *)p1 - *(int *)p2;
}

int triangleNumber(int* nums, int numsSize) {
    int i, left, right, curr, ret = 0;
    
    if (! numsSize)
        return 0;
    qsort(nums, numsSize, sizeof(int), &comp);
    
    for (i = numsSize - 1; i >= 2; --i) {
        left = 0;
        right = i - 1;
        curr = nums[i];
        
        while (left < right) {
            if (nums[left] + nums[right] > curr) {
                ret += right - left;
                --right;
            } else
                ++left;
        }
    }
    
    return ret;
}
