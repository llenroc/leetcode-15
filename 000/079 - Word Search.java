public class Solution {
    public boolean exist(char[][] board, String word) {
        int rows, cols, i, j;
        char[] c;
        boolean[][] used;
        
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        
        rows = board.length;
        cols = board[0].length;
        used = new boolean[rows][cols];
        
        for (i = 0; i < rows; ++i) {
            c = board[i];
            for (j = 0; j < cols; ++j) {
                if (c[j] == word.charAt(0)) {
                    if (word.length() == 1 || helper(i, j, rows, cols, board, used, word.substring(1)))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(int row, int col, int rows, int cols, char[][] board, boolean[][] used, String word) {
        int i, nr, nc;
        
        used[row][col] = true;
        
        for (i = 0; i < 4; ++i) {
            nr = row;
            nc = col;
            if (i == 0)
                ++nr;
            else if (i == 1)
                --nr;
            else if (i == 2)
                ++nc;
            else
                --nc;
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                continue;
            if (board[nr][nc] == word.charAt(0) && ! used[nr][nc]) {
                if (word.length() == 1 || helper(nr, nc, rows, cols, board, used, word.substring(1)))
                    return true;
            }
        }
        
        used[row][col] = false;
        return false;
    }
}
