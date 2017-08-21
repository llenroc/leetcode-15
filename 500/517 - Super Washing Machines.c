#include <stdlib.h>

static inline int max(int a, int b) {
    return a > b ? a : b;
}

int findMinMoves(int* machines, int machinesSize) {
    int *sum, ret = 0, i, left, right, avg;
    
    if (! machinesSize)
        return 0;
    sum = (int *)malloc((machinesSize + 1) * sizeof(int));
    sum[0] = 0;
    for (i = 0; i < machinesSize; ++i)
        sum[i + 1] = sum[i] + machines[i];
    if (sum[machinesSize] % machinesSize)
        return -1;
    avg = sum[machinesSize] / machinesSize;
    
    for (i = 0; i < machinesSize; ++i) {
        left = sum[i] - avg * i;
        right = sum[machinesSize] - sum[i + 1] - avg * (machinesSize - 1 - i);

        if (left < 0 && right < 0)
            ret = max(ret, -left - right);
        else
            ret = max(ret, max(abs(left), abs(right)));
    }
    
    free(sum);
    
    return ret;
}
