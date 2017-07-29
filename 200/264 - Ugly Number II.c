#define min(a, b) ((a) < (b) ? (a) : (b))

int nthUglyNumber(int n) {
    int i2 = 0, i3 = 0, i5 = 0, m2, m3, m5, t, count = 1, *m, ret;
    
    m = (int *)malloc(n * sizeof(int));
    memset(m, 0, n * sizeof(int));
    m[0] = 1;
    
    while (count < n) {
        m2 = m[i2] * 2;
        m3 = m[i3] * 3;
        m5 = m[i5] * 5;
        t = min(m2, min(m3, m5));
        
        if (t == m2)
            ++i2;
        if (t == m3)
            ++i3;
        if (t == m5)
            ++i5;
        
        m[count++] = t;
    }
    
    ret = m[n - 1];
    free(m);
    
    return ret;
}
