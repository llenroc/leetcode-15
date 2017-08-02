import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> p1, Map.Entry<Integer, Integer> p2) {
                return p2.getValue() - p1.getValue();
            }
        });
        List<Integer> ret = new ArrayList<Integer>(k);
        int i;
        
        for (int num : nums) {
            if (hm.containsKey(num))
                hm.put(num, hm.get(num) + 1);
            else
                hm.put(num, 1);
        }
            
        for (Map.Entry e : hm.entrySet())
            queue.add(e);
        
        for (i = 0; i < k; i++)
            ret.add(queue.poll().getKey());
        
        return ret;
    }
}
