#define max(a, b) ((a) > (b) ? (a) : (b))
#define min(a, b) ((a) < (b) ? (a) : (b))
#define rs dungeonRowSize
#define cs dungeonColSize

int calculateMinimumHP(int** dungeon, int dungeonRowSize, int dungeonColSize) {
    int ret, *dp, i, j, *curr;
    
    if (! (dungeonRowSize && dungeonColSize))
        return 0;
    dp = (int *)malloc(cs * sizeof(int));
    dp[cs - 1] = max(1, 1 - dungeon[rs - 1][cs - 1]);
    
    for (j = cs - 2; j >= 0; --j)
        dp[j] = max(1, dp[j + 1] - dungeon[rs - 1][j]);
    
    for (i = rs - 2; i >= 0; --i) {
        curr = dungeon[i];
        dp[cs - 1] = max(1, dp[cs - 1] - curr[cs - 1]);
        
        for (j = cs - 2; j >= 0; --j)
            dp[j] = max(1, min(dp[j], dp[j + 1]) - curr[j]);
    }
    
    ret = dp[0];
    free(dp);
    
    return ret;
}
