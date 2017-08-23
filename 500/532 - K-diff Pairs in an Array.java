import java.util.HashMap;

class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int ret = 0;
        
        for (int num : nums) {
            if (hm.containsKey(num))
                hm.replace(num, hm.get(num) + 1);
            else
                hm.put(num, 1);
        }
        
        for (HashMap.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (k == 0 && entry.getValue() > 1)
                ++ret;
            if (k > 0 && hm.containsKey(entry.getKey() + k))
                ++ret;
        }
        
        return ret;
    }
}
