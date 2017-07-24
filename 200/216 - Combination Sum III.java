import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        helper(k, n, 1, new ArrayList<Integer>(), ret);
        
        return ret;
    }
    
    private void helper(int k, int n, int from, List<Integer> prefix, List<List<Integer>> ret) {
        int i;
        
        if (n < 0)
            return;
        
        if (n == 0 && prefix.size() == k) {
            ret.add(new ArrayList<Integer>(prefix));
            return;
        }
    
        for (i = from; i <= 9; ++i) {
            prefix.add(i);
            helper(k, n - i, i + 1, prefix, ret);
            prefix.remove(prefix.size() - 1);
        }
    }
}
