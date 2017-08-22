#include <string.h>

#define max(a, b) ((a) > (b) ? (a) : (b))

int longestSubstring(char* s, int k) {
    int ret = 0, i = 0, j, max_i, count[26], len, mask, curr;
    
    len = strlen(s);
    while (i + k <= len) {
        memset(count, 0, 26 * sizeof(int));
        mask = 0;
        max_i = i;
        
        for (j = i; j < len; ++j) {
            curr = s[j] - 'a';
            
            if (++count[curr] < k)
                mask |= (1 << curr);
            else
                mask &= ~ (1 << curr);
            
            if (! mask) {
                ret = max(ret, j - i + 1);
                max_i = j;
            }
        }
        
        i = max_i + 1;
    }
    
    return ret;
}