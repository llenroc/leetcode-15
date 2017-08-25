class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb;
        int i;
        
        switch (nums.length) {
            case 0:
                return "";
            case 1:
                return Integer.toString(nums[0]);
            case 2:
                return String.format("%d/%d", nums[0], nums[1]);
            default:
                sb = new StringBuilder();
                sb.append(nums[0]);
                sb.append("/(");
                sb.append(nums[1]);
                
                for (i = 2; i < nums.length; ++i) {
                    sb.append('/');
                    sb.append(nums[i]);
                }
                
                sb.append(')');
                return sb.toString();
        }
    }
}
