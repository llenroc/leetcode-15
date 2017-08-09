import java.util.ArrayList;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<String>();
        List<Integer> hours = new ArrayList<Integer>(), minutes = new ArrayList<Integer>();
        int[] h = {1, 2, 4, 8}, m = {1, 2, 4, 8, 16, 32};
        int i;
        
        for (i = 0; i <= num; ++i) {
            choose(h, i, hours);
            choose(m, num - i, minutes);
            
            for (int a : hours) {
                if (a > 11)
                    continue;
                
                for (int b : minutes) {
                    if (b > 59)
                        continue;
                    ret.add(String.format("%d:%02d", a, b));
                }
            }
        }
        
        return ret;
    }
    
    private void choose(int[] nums, int count, List<Integer> ret) {
        ret.clear();
        helper(nums, count, 0, 0, ret);
    }
    
    private void helper(int[] nums, int count, int index, int sum, List<Integer> ret) {
        int i;
        
        if (count == 0) {
            ret.add(sum);
            return;
        }
        
        if (index + count > nums.length)
            return;
        
        for (i = index; i < nums.length; ++i)
            helper(nums, count - 1, i + 1, sum + nums[i], ret);
    }
}
