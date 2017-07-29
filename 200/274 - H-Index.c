int hIndex(int* citations, int citationsSize) {
    int *count, i, c;
    
    if (! citationsSize)
        return 0;
    count = (int *)malloc((citationsSize + 1) * sizeof(int));
    memset(count, 0, (citationsSize + 1) * sizeof(int));
    
    for (i = 0; i < citationsSize; ++i) {
        c = citations[i];
        if (c < citationsSize)
            ++count[c];
        else
            ++count[citationsSize];
    }
    
    c = 0;
    for (i = citationsSize; i >= 0; --i) {
        c += count[i];
        
        if (c >= i)
            return i;
    }
    
    free(count);
    
    return 0;
}
