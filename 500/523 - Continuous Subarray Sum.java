import java.util.HashSet;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        int r, sum = 0, prev = 0;
        
        for (int num : nums) {
            sum += num;
            r = k == 0 ? sum : sum % k;
            
            if (set.contains(r))
                return true;
            
            set.add(prev);
            prev = r;
        }
        
        return false;
    }
}
