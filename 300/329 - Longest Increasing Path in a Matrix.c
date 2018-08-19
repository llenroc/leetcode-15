int dirs[] = {0, 1, 0, -1, 1, 0, -1, 0};

static int max(int a, int b) {
    return a > b ? a : b;
}

static int dfs(int **matrix, int **dp, int matrixRowSize, int matrixColSize, int r, int c) {
    int ret = 1, dr, dc, i;
    
    if (dp[r][c])
        return dp[r][c];
    
    for (i = 0; i < 4; ++i) {
        dr = r + dirs[2 * i];
        dc = c + dirs[2 * i + 1];
        
        if (dr < 0 || dr >= matrixRowSize || dc < 0 || dc >= matrixColSize || matrix[dr][dc] <= matrix[r][c])
            continue;
        ret = max(ret, 1 + dfs(matrix, dp, matrixRowSize, matrixColSize, dr, dc));
    }
    
    dp[r][c] = ret;
    
    return ret;
}

int longestIncreasingPath(int** matrix, int matrixRowSize, int matrixColSize) {
    int **dp, *temp, i, j, ret = 0;
    
    if (! (matrixRowSize && matrixColSize))
        return 0;
    
    temp = (int *)calloc(matrixRowSize * matrixColSize, sizeof(int));
    dp = (int **)malloc(matrixRowSize * sizeof(int *));
    for (i = 0; i < matrixRowSize; ++i) {      
        dp[i] = temp + i * matrixColSize;
    }
    
    for (i = 0; i < matrixRowSize; ++i) {
        for (j = 0; j < matrixColSize; ++j) {
            ret = max(ret, dfs(matrix, dp, matrixRowSize, matrixColSize, i, j));
        }
    }
    
    free(dp);
    free(temp);
    
    return ret;
}
