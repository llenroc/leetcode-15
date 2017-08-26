int arrayNesting(int* nums, int numsSize) {
    int *visited, i, j, m = 0, count;
    
    if (! numsSize)
        return 0;
    visited = (int *)calloc(numsSize, sizeof(int));
    
    for (i = 0; i < numsSize; ++i) {
        if (visited[i])
            continue;
        
        count = 0;
        j = i;
        
        while (j != i || ! count) {
            visited[j] = 1;
            j = nums[j];
            ++count;
        }
        
        if (count > m)
            m = count;
    }
    
    free(visited);
    
    return m;
}
