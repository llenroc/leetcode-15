#include <stdlib.h>

#define min(a, b) ((a) < (b) ? (a) : (b))

static int comp(const void *pp1, const void *pp2) {
    int *p1 = *(int **)pp1, *p2 = *(int **)pp2;
    
    if (p1[0] == p2[0])
        return p1[1] - p2[1];
    return p1[0] - p2[0];
}

int findMinArrowShots(int** points, int pointsRowSize, int pointsColSize) {
    int ret = 0, i, prev;
    
    if (pointsRowSize) {
        qsort(points, pointsRowSize, sizeof(int *), &comp);
        
        ++ret;
        prev = points[0][1];
        for (i = 1; i < pointsRowSize; ++i) {
            if (points[i][0] <= prev)
                prev = min(prev, points[i][1]);
            else {
                ++ret;
                prev = points[i][1];
            }
        }
    }
    
    return ret;
}
