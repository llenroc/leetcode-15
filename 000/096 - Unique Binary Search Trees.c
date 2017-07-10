int numTrees(int n) {
    int *trees, i, j, ret;
    
    trees = (int *)malloc((n + 1) * sizeof(int));
    memset(trees, 0, (n + 1) * sizeof(int));
    trees[0] = 1;
    
    for (i = 1; i <= n; ++i) {
        for (j = 0; j < i; ++j)
            trees[i] += trees[j] * trees[i - 1 - j];
    }
    
    ret = trees[n];
    free(trees);
    
    return ret;
}
