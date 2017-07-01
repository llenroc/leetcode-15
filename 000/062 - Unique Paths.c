int uniquePaths(int m, int n) {
    int *dp, i, j, ret;
    
    dp = (int *)malloc(n * sizeof(int));
    for (i = 0; i < n; ++i)
        dp[i] = 1;
    
    for (i = 1; i < m; ++i) {
        for (j = 1; j < n; ++j)
            dp[j] += dp[j - 1];
    }
    
    ret = dp[n - 1];
    free(dp);
    
    return ret;
}
