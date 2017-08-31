bool checkRecord(char* s) {
    char c;
    int a_flag = 0, l_flag = 0;
    
    while ((c = *s++)) {
        if (c != 'L') {
            if (c == 'A') {
                if (a_flag)
                    return 0;
                else
                    a_flag = 1;
            }
            
            l_flag = 0;
        } else {
            if (++l_flag >= 3)
                return 0;
        }
    }
    
    return 1;
}