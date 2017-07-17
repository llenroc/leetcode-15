import java.util.HashSet;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<String>();
        boolean[] dp;
        int i, j;
        
        if (s == null || wordDict == null)
            return false;
        dp = new boolean[s.length() + 1];
        
        for (String word : wordDict)
            dict.add(word);
        
        dp[0] = true;
        for (i = 0; i < s.length(); ++i) {
            for (j = i; j >= 0; --j) {
                if (dp[j] && dict.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
