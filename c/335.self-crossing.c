/*
 * @lc app=leetcode id=335 lang=c
 *
 * [335] Self Crossing
 *
 * autogenerated using scripts/convert.py
 */
bool isSelfCrossing(int* x, int xSize) {
    int i;
    
    for (i = 3; i < xSize; ++i) {
        if (x[i - 3] >= x[i - 1] &&
            x[i] >= x[i - 2])
            return 1;
        
        if (i >= 4 && 
            x[i - 4] + x[i] >= x[i - 2] &&
            x[i - 3] == x[i - 1])
            return 1;
        
        if (i >= 5 && 
           x[i - 4] + x[i] >= x[i - 2] &&
           x[i - 2] >= x[i - 4] && 
           x[i - 1] + x[i - 5] >= x[i - 3] &&
           x[i - 3] >= x[i - 1])
        return 1;
        
    }
    
    return 0;
}
