#define min(a, b) ((a) < (b) ? (a) : (b))

int coinChange(int* coins, int coinsSize, int amount) {
    int *dp, i, j, ret;
    
    dp = (int *)malloc((amount + 1) * sizeof(int));
    dp[0] = 0;
    
    for (i = 1; i <= amount; ++i) {
        dp[i] = amount + 1;
        for (j = 0; j < coinsSize; ++j) {
            if (coins[j] <= i)
                dp[i] = min(dp[i], dp[i - coins[j]] + 1);
        }
    }
    
    ret = dp[amount] <= amount ? dp[amount] : -1;
    free(dp);
    
    return ret;
}
