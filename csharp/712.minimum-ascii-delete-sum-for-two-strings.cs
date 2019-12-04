/*
 * @lc app=leetcode id=712 lang=csharp
 *
 * [712] Minimum ASCII Delete Sum for Two Strings
 */

// @lc code=start
public class Solution {
    public int MinimumDeleteSum(string s1, string s2) {
        int m = s1.Length, n = s2.Length;
        int[,] dp = new int[m + 1, n + 1];
        for (int j = 1; j <= n; ++j) {
            dp[0, j] = dp[0, j - 1] + (int) s2[j - 1];
        }
        for (int i = 1; i <= m; ++i) {
            dp[i, 0] = dp[i - 1, 0] + (int) s1[i - 1];
            for (int j = 1; j <= n; ++j) {
                dp[i, j] = s1[i - 1] == s2[j - 1] ? dp[i - 1, j - 1] : Math.Min(dp[i - 1, j] + (int) s1[i - 1], dp[i, j - 1] + (int) s2[j - 1]);
            }
        }
        return dp[m, n];
    }
}
// @lc code=end

