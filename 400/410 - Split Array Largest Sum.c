#include <limits.h>

#define max(a, b) ((a) > (b) ? (a) : (b))
#define min(a, b) ((a) < (b) ? (a) : (b))

int splitArray(int* nums, int numsSize, int m) {
    int **dp, *temp, *curr, *sums, i, j, k, val, ret;
    
    if (! (numsSize && m))
        return 0;
    
    dp = (int **)malloc((m + 1) * sizeof(int *));
    temp = (int *)malloc((m + 2) * (numsSize + 1) * sizeof(int));
    for (i = 0; i <= m; ++i) {
        curr = temp + i * (numsSize + 1);
        dp[i] = curr;
        
        for (j = 0; j <= numsSize; ++j)
            curr[j] = INT_MAX;
    }
    dp[0][0] = 0;
    
    sums = temp + (m + 1) * (numsSize + 1);
    sums[0] = 0;
    for (i = 1; i <= numsSize; ++i)
        sums[i] = sums[i - 1] + nums[i - 1];
    
    for (i = 1; i <= m; ++i) {
        
        for (j = 1; j <= numsSize; ++j) {
            
            for (k = i - 1; k < j; ++k) {
                val = max(dp[i - 1][k], sums[j] - sums[k]);
                dp[i][j] = min(dp[i][j], val);
            }
        }
    }
    
    ret = dp[m][numsSize];
    free(temp);
    free(dp);
    
    return ret;
}
