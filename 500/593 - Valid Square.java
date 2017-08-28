import java.util.HashSet;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<Integer>();
        int[][] s = {p1, p2, p3, p4};
        int i, j, d;
        
        for (i = 0; i < 4; ++i) {
            for (j = i + 1; j < 4; ++j) {
                d = (s[i][0] - s[j][0]) * (s[i][0] - s[j][0]) + (s[i][1] - s[j][1]) * (s[i][1] - s[j][1]);
                
                if (d == 0)
                    return false;
                
                set.add(d);
            }
        }
        
        return set.size() == 2;
    }
}
