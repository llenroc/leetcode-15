#define max(a, b) ((a) > (b) ? (a) : (b))

static int helper(int* nums, int numsSize, int *dp) {
    int i;
    
    if (numsSize == 1)
        return nums[0];
    dp[0] = nums[0];
    dp[1] = max(nums[0], nums[1]);
    
    for (i = 2; i < numsSize; ++i)
        dp[i] = max(nums[i] + dp[i - 2], dp[i - 1]);
    
    return dp[numsSize - 1];
}

int rob(int* nums, int numsSize) {
    int left, right, *dp;
    
    if (! numsSize)
        return 0;
    if (numsSize == 1)
        return nums[0];
    dp = (int *)malloc(sizeof(int) * (numsSize - 1));
    
    left = helper(nums, numsSize - 1, dp);
    right = helper(nums + 1, numsSize - 1, dp);
    
    free(dp);
    
    return max(left, right);
}
