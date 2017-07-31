#include <limits.h>

#define min(a, b) ((a) < (b) ? (a) : (b))

int nthSuperUglyNumber(int n, int* primes, int primesSize) {
    int *indices, *temp, *mins, i, j, m, ret;
    
    if (! primesSize)
        return 0;
    temp = (int *)malloc((n + 2 * primesSize) * sizeof(int));
    temp[0] = 1;
    indices = temp + n;
    memset((void *)indices, 0, primesSize * sizeof(int));
    mins = indices + primesSize;
    
    for (i = 1; i < n; ++i) {
        m = INT_MAX;
        for (j = 0; j < primesSize; ++j) {
            mins[j] = temp[indices[j]] * primes[j];
            m = min(mins[j], m);
        }
        
        for (j = 0; j < primesSize; ++j) {
            if (m == mins[j])
                ++indices[j];
        }
        
        temp[i] = m;
    }
    
    ret = temp[n - 1];
    free(temp);
    
    return ret;
}
