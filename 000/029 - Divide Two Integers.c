#include <limits.h>

int divide(int dividend, int divisor) {
    long long m, n, ret = 0, div, temp;
    int neg;
    
    if (divisor == 0 || (dividend == INT_MIN && divisor == -1))
        return INT_MAX;
    m = (long long)dividend;
    if (m < 0)
        m = -m;
    n = (long long)divisor;
    if (n < 0)
        n = -n;
    neg = (dividend > 0) ^ (divisor > 0);
    
    if (divisor == 1)
        return dividend;

    while (m >= n) {
        div = n;
        temp = 1;
        
        while (m >= (div << 1)) {
            div <<= 1;
            temp <<= 1;
        }
        
        ret += temp;
        m -= div;
    }
    
    return neg ? -(int)ret : (int)ret;
}
