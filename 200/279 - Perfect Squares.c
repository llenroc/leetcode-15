#include <limits.h>

#define min(a, b) ((a) < (b) ? (a) : (b))

int numSquares(int n) {
    int *dp, i, j, c, ret;
    
    dp = (int *)malloc((n + 1) * sizeof(int));
    dp[0] = 0;
    for (i = 1; i <= n; ++i)
        dp[i] = INT_MAX;
    
    for (i = 0; i <= n; ++i) {
        for (j = 1; (c = i + j * j) <= n; ++j)
            dp[c] = min(dp[c], dp[i] + 1);
    }
    
    ret = dp[n];
    free(dp);
    
    return ret;
}
