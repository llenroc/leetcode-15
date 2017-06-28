int myAtoi(const char* str) {
    int neg = 0;
    unsigned long long ret = 0;
    char c;
    while ((c = *str++) == ' ')
        ;
    if (c == '-') {
        neg = 1;
        c = *str++;
    } else if (c == '+')
        c = *str++;

    while (c >= '0' && c <= '9') {
        ret *= 10;
        ret += (c - '0');
        if ((neg && ret > -INT_MIN) || ret > INT_MAX) {
            ret = neg ? (unsigned long long)(-INT_MIN) : (unsigned long long)INT_MAX;
            break;
        }
        c = *str++;
    }
    return neg ? -(signed int)ret : (signed int)ret;
}
