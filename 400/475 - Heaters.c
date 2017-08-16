#include <stdlib.h>

static inline int max(int a, int b) {
    if (a > b)
        return a;
    else
        return b;
}

static int comp(const void *p1, const void *p2) {
    return *(int *)p1 - *(int *)p2;
}

int findRadius(int* houses, int housesSize, int* heaters, int heatersSize) {
    int i, ret = 0, j = 0, curr;
    
    qsort(houses, housesSize, sizeof(int), &comp);
    qsort(heaters, heatersSize, sizeof(int), &comp);
    
    for (i = 0; i < housesSize; ++i) {
        curr = houses[i];
        
        while (j < heatersSize - 1 && abs(heaters[j + 1] - curr) <= abs(heaters[j] - curr))
            ++j;
        
        ret = max(ret, abs(heaters[j] - curr));
    }
    
    return ret;
}
