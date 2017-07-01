#define min(a, b) (a < b ? a : b)

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* spiralOrder(int** matrix, int matrixRowSize, int matrixColSize) {
    int r_max, c_max, i, j, times, size = 0, *ret;
    
    times = (min(matrixRowSize, matrixColSize) + 1) / 2;
    ret = (int *)malloc(matrixRowSize * matrixColSize * sizeof(int));
    for (i = 0; i < times; ++i) {
        r_max = matrixRowSize - 1 - i;
        c_max = matrixColSize - 1 - i;
        if (i == r_max) {
            for (j = i; j <= c_max; ++j)
                ret[size++] = matrix[i][j];
        } else if (i == c_max) {
            for (j = i; j <= r_max; ++j)
                ret[size++] = matrix[j][i];
        } else {
            for (j = i; j < c_max; ++j)
                ret[size++] = matrix[i][j];
            for (j = i; j < r_max; ++j)
                ret[size++] = matrix[j][c_max];
            for (j = c_max; j > i; --j)
                ret[size++] = matrix[r_max][j];
            for (j = r_max; j > i; --j)
                ret[size++] = matrix[j][i];
        }
    }
    
    return ret;
}
