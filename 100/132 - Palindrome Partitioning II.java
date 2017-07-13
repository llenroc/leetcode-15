public class Solution {
    public int minCut(String s) {
        boolean[][] isPalindrome;
        int i, j;
        int dp[];
        
        if (s == null)
            return 0;
        isPalindrome = new boolean[s.length()][s.length()];
        dp = new int[s.length() + 1];
        
        for (i = s.length() - 1; i >= 0; --i) {
            for (j = i; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j) && (i >= j - 2 || isPalindrome[i + 1][j - 1]))
                    isPalindrome[i][j] = true;
            }
        }
        
        dp[0] = -1;
        for (i = 1; i <= s.length(); ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; ++j) {
                if (isPalindrome[j][i - 1])
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        
        return dp[s.length()] >= 0 ? dp[s.length()] : 0;
    }
}
