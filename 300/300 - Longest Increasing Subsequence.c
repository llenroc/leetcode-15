#define max(a, b) ((a) > (b) ? (a) : (b))

int lengthOfLIS(int* nums, int numsSize) {
    int *dp, i, j, ret = 1;
    
    if (! numsSize)
        return 0;
    dp = (int *)malloc(numsSize * sizeof(int));
    memset(dp, 0, numsSize * sizeof(int));
    dp[0] = 1;
    
    for (i = 1; i < numsSize; ++i) {
        for (j = i - 1; j >= 0; --j) {
            if (nums[j] < nums[i])
                dp[i] = max(dp[i], dp[j]);
        }
        dp[i] += 1;
        ret = max(ret, dp[i]);
    }
    
    free(dp);
    return ret;
}
