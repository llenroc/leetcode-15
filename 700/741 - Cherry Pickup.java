class Solution {
    public int cherryPickup(int[][] grid) {
        int len = grid.length;
        int maxSteps = 2 * (len - 1);
        int[][] dp = new int[len][len];
        
        dp[0][0] = grid[0][0];
        
        for (int steps = 1; steps <= maxSteps; ++steps) {
            for (int i = len - 1; i >= 0; --i) {
                for (int p = len - 1; p >= 0; --p) {
                    int j = steps - i, q = steps - p;
                    
                    if (j < 0 || j >= len || q < 0 || q >= len || grid[i][j] < 0 || grid[p][q] < 0) {
                        dp[i][p] = -1;
                        continue;
                    }
                    
                    if (i > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i - 1][p]);
                    }
                    
                    if (p > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i][p - 1]);
                    }
                    
                    if (i > 0 && p > 0) {
                        dp[i][p] = Math.max(dp[i][p], dp[i - 1][p - 1]);
                    }
                    
                    if (dp[i][p] >= 0) {
                        dp[i][p] += grid[i][j] + (i == p ? 0 : grid[p][q]);
                    }
                }
            }
        }
        
        return Math.max(0, dp[len - 1][len - 1]);
    }
}