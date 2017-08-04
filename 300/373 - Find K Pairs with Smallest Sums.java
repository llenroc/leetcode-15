import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] + p1[1] - p2[0] - p2[1];
            }
        });
        List<int[]> ret = new ArrayList<int[]>(k);
        
        for (int a : nums1) {
            for (int b : nums2)
                queue.add(new int[]{a, b});
        }
        
        while (k-- > 0 && ! queue.isEmpty())
            ret.add(queue.poll());
        
        return ret;
    }
}
