public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1, len2, len3, i, j;
        boolean[] dp;
        
        if (s1 == null || s2 == null || s3 == null)
            return false;
        len1 = s1.length();
        len2 = s2.length();
        len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        dp = new boolean[len1 + 1];
        
        dp[0] = true;
        for (i = 1; i <= len1; ++i) {
            if (! (dp[i] = dp[i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1))))
                break;
        }
        
        for (j = 1; j <= len2; ++j) {
            dp[0] &= s2.charAt(j - 1) == s3.charAt(j - 1);
            for (i = 1; i <= len1; ++i)
                dp[i] = (dp[i] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))) || (dp[i - 1] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)));
        }
        
        return dp[len1];
    }
}
