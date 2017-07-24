import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new ArrayList<int[]>(), points = new ArrayList<int[]>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n2 - n1;
            }
        });
        int curr, pre;
        
        for (int[] pair : buildings) {
            points.add(new int[]{pair[0], pair[2]});
            points.add(new int[]{pair[1], -pair[2]});
        }
        
        Collections.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[]p2) {
                if (p1[0] != p2[0])
                    return p1[0] - p2[0];
                return p2[1] - p1[1];
            }
        });
        
        pre = 0;
        for (int[] pair : points) {
            if (pair[1] > 0) {
                heap.offer(pair[1]);
                curr = heap.peek();
            } else {
                heap.remove(-pair[1]);
                curr = heap.peek() == null ? 0 : heap.peek();
            }
            
            if (curr != pre) {
                ret.add(new int[]{pair[0], curr});
                pre = curr;
            }
        }
        
        return ret;
    }
}
