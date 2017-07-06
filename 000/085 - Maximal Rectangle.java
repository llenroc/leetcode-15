import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows, cols, i, j, area = 0, len, h;
        int[] hist;
        Stack<Integer> stack = new Stack<Integer>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        rows = matrix.length;
        cols = matrix[0].length;
        len = cols + 2;
        hist = new int[len];
        hist[0] = -1;
        hist[cols + 1] = -1;
    
        for (i = 0; i < rows; ++i) {
            stack.clear();
            stack.push(0);
            for (j = 0; j < cols; ++j)
                hist[j + 1] = (matrix[i][j] == '1' ? 1 + hist[j + 1] : 0);
            for (j = 0; j < len; ++j) {
                while (hist[j] < hist[stack.peek()]) {
                    h = hist[stack.pop()];
                    area = Math.max(area, h * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
        }
        
        return area;
    }
}
