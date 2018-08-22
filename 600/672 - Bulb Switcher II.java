import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

class Solution {
    
    private int all(int state, int n) {
        return state ^ ((1 << n) - 1);
    }
    
    private int odd(int state, int n) {
        for (int i = 1; i < n; i += 2) {
            state ^= 1 << i;
        }
        
        return state;
    }
    
    private int even(int state, int n) {
        for (int i = 0; i < n; i += 2) {
            state ^= 1 << i;
        }
        
        return state;
    }
    
    private int three(int state, int n) {
        for (int i = 0; i < n; i += 3) {
            state ^= 1 << i;
        }
        
        return state;
    }
    
    public int flipLights(int n, int m) {
        n = n > 6 ? (n % 6 + 6) : n;
        int state = (1 << n) - 1;
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        q.offer(state);
        
        while (m-- > 0) {
            int x = q.size();
            set.clear();
            
            while (x-- > 0) {
                int s = q.poll();
                
                int[] temp = new int[] {
                    all(s, n),
                    even(s, n),
                    odd(s, n),
                    three(s, n)
                };
                
                for (int t : temp) {
                    if (set.contains(t)) {
                        continue;
                    }
                    
                    set.add(t);
                    q.offer(t);
                }
            }
        }
        
        return q.size();
    }
}