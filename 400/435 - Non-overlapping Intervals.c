#include <stdlib.h>

static int comp(const void *p1, const void *p2) {
    return ((struct Interval *)p1)->start - ((struct Interval *)p2)->start;
}

/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 * };
 */
int eraseOverlapIntervals(struct Interval* intervals, int intervalsSize) {
    int i, prev = 0, ret = 0;
    
    qsort(intervals, intervalsSize, sizeof(struct Interval), &comp);
    
    for (i = 1; i < intervalsSize; ++i) {
        if (intervals[i].start < intervals[prev].end) {
            ++ret;
            if (intervals[i].end < intervals[prev].end)
                prev = i;
        } else
            prev = i;
    }
    
    return ret;
}
