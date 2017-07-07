static void count(char *s, int *ret_p) {
    switch (*s) {
        case '\0':
            ++*ret_p;
            return;
        case '0':
            return;
        case '1':
            if (s[1])
                count(s + 2, ret_p);
            break;
        case '2':
            if (s[1] >= '0' && s[1] <= '6')
                count(s + 2, ret_p);
            break;
    }
    count(s + 1, ret_p);
}

int numDecodings(char* s) {
    int ret = 0;
    
    if (s && *s)
        count(s, &ret);
    
    return ret;
}
