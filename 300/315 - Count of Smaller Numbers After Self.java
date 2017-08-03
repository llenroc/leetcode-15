import java.util.ArrayList;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> added = new ArrayList<Integer>(nums.length), ret = new ArrayList<Integer>(nums.length);
        int i, left, right, mid;
        
        for (i = 0; i < nums.length; ++i)
            ret.add(0);
        
        for (i = nums.length - 1; i >= 0; --i) {
            left = 0;
            right = added.size();
            
            while (left < right) {
                mid = left + (right - left) / 2;
                if (added.get(mid) >= nums[i])
                    right = mid;
                else
                    left = mid + 1;
            }
            
            ret.set(i, right);
            added.add(right, nums[i]);
        }
        
        return ret;
    }
}
