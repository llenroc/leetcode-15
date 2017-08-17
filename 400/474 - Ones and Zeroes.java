public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int zeroes, ones, i, j;
        
        for (String s : strs) {
            zeroes = 0;
            ones = 0;
            
            for (char c : s.toCharArray()) {
                if (c == '0')
                    ++zeroes;
                else
                    ++ones;
            }
            
            for (i = m; i >= zeroes; --i) {
                for (j = n; j >= ones; --j)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
            }
        }
        
        return dp[m][n];
    }
}
