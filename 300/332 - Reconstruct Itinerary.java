import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        List<String> ret = new ArrayList<String>(), l;
        
        for (String[] pair : tickets) {
            if ((l = hm.get(pair[0])) == null) {
                l = new ArrayList<String>();
                hm.put(pair[0], l);
            }
            l.add(pair[1]);
        }

        dfs(hm, "JFK", ret);
        
        return ret;
    }
    
    private void dfs(HashMap<String, List<String>> hm, String s, List<String> ret) {
        List<String> l;
        
        if ((l = hm.get(s)) != null) {
            Collections.sort(l);
            
            while (l.size() > 0)
                dfs(hm, l.remove(0), ret);
        }
        
        ret.add(0, s);
    }
}