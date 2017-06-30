import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<Integer>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int i;
        
        if (nums == null)
            return null;
        for (i = 0; i < nums.length; ++i)
            numsList.add(nums[i]);
        
        helper(ret, new ArrayList<Integer>(), numsList);
        
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, List<Integer> prefix, List<Integer> nums) {
        List<Integer> newPrefix, newNums;
        int i;
        
        if (nums.size() == 0)
            ret.add(prefix);
        else {
            for (i = 0; i < nums.size(); ++i) {
                newPrefix = new ArrayList<Integer>(prefix);
                newPrefix.add(nums.get(i));
                newNums = new ArrayList<Integer>(nums);
                newNums.remove(i);
                helper(ret, newPrefix, newNums);
            }
        }
    }
}
