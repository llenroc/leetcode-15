import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<Integer>(), newRet = new ArrayList<Integer>(), temp;
        List<HashSet<Integer>> neighbors = new ArrayList<HashSet<Integer>>(n);
        int i, d;
        
        for (i = 0; i < n; ++i)
            neighbors.add(new HashSet<Integer>());
        
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        
        for (i = 0; i < n; ++i) {
            if (neighbors.get(i).size() <= 1)
                ret.add(i);
        }
        
        while (n > 2) {
            n -= ret.size();
            
            for (Integer l : ret) {
                d = neighbors.get(l).iterator().next();
                neighbors.get(d).remove(l);
                
                if (neighbors.get(d).size() == 1)
                    newRet.add(d);
            }
            
            temp = ret;
            ret = newRet;
            newRet = temp;
            newRet.clear();
        }
        
        return ret;
    }
}
