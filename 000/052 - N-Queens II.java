import java.util.ArrayList;

public class Solution {
    public int totalNQueens(int n) {
        return helper(n, 0, new ArrayList<Integer>());
    }
    
    private int helper(int n, int row, List<Integer> cols) {
        int i, j, c, ret = 0;
        boolean flag;
        
        if (row == n)
            return 1;
        else {
            for (i = 0; i < n; ++i) {
                flag = true;
                for (j = 0; j < cols.size(); ++j) {
                    c = cols.get(j);
                    if (i == c || Math.abs(c - i) == Math.abs(j - row)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cols.add(i);
                    ret += helper(n, row + 1, cols);
                    cols.remove(cols.size() - 1);
                }
            }

            return ret;
        }
    }
}
