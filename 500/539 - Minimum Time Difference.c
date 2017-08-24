#include <stdio.h>
#include <stdlib.h>

static inline min(int a, int b) {
    return a < b ? a : b;
}

static int comp(const void *p1, const void *p2) {
    return *(int *)p1 - *(int *)p2;
}

int findMinDifference(char** timePoints, int timePointsSize) {
    int i, m, h, *p, ret, prev, curr;
    
    if (timePointsSize <= 1)
        return -1;
    p = (int *)malloc(timePointsSize * sizeof(int));
    
    for (i = 0; i < timePointsSize; ++i) {
        sscanf(timePoints[i], "%d:%d\n", &h, &m);
        p[i] = h * 60 + m;
    }
    
    qsort(p, timePointsSize, sizeof(int), &comp);
    
    ret = 1440 + p[0] - p[timePointsSize - 1];
    prev = p[0];
    for (i = 1; i < timePointsSize; ++i) {
        curr = p[i];
        ret = min(ret, min(curr - prev, 1440 + prev - curr));
        prev = curr;
    }
    
    free(p);
    return ret;
}
