public class NumArray {

    int[] dp;
    
    public NumArray(int[] nums) {
        int i;
        
        this.dp = nums;
        for (i = 1; i < nums.length; ++i)
            this.dp[i] += this.dp[i - 1];
    }
    
    public int sumRange(int i, int j) {
        if (i == 0)
            return this.dp[j];
        return this.dp[j] - this.dp[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
 