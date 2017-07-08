import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        if (nums != null) {
            Arrays.sort(nums);
            findPermutation(nums, new boolean[nums.length], new ArrayList<Integer>(), ret);
        }
        
        return ret;
    }
    
    private void findPermutation(int[] nums, boolean[] used, List<Integer> prefix, List<List<Integer>> ret) {
        int i;
        
        if (prefix.size() == nums.length) {
            ret.add(new ArrayList<Integer>(prefix));
            return;
        }
        
        for (i = 0; i < nums.length; ++i) {
            if ((used[i]) || (i > 0 && nums[i] == nums[i - 1] && ! used[i - 1]))
                continue;
            used[i] = true;
            prefix.add(nums[i]);
            findPermutation(nums, used, prefix, ret);
            prefix.remove(prefix.size() - 1);
            used[i] = false;
        }
    }
}
