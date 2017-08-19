import java.util.HashMap;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length, i, sum, count;
        HashMap<Integer, Integer> next = new HashMap<Integer, Integer>(), curr = new HashMap<Integer, Integer>(), temp;
        
        curr.put(0, 1);
        
        for (i = 0; i < len ; ++i) {
            for (HashMap.Entry<Integer, Integer> entry : curr.entrySet()) {
                sum = entry.getKey();
                count = entry.getValue();
                
                if (! next.containsKey(sum + nums[i]))
                    next.put(sum + nums[i], count);
                else
                    next.replace(sum + nums[i], count + next.get(sum + nums[i]));
                
                if (! next.containsKey(sum - nums[i]))
                    next.put(sum - nums[i], count);
                else
                    next.replace(sum - nums[i], count + next.get(sum - nums[i]));
            }
            
            curr.clear();
            temp = curr;
            curr = next;
            next = temp;
        }
        
        if (curr.containsKey(S))
            return curr.get(S);
        else 
            return 0;
    }
}
