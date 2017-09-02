static inline int max(int a, int b) {
    return a > b ? a : b;
}

int leastInterval(char* tasks, int tasksSize, int n) {
    int count[26] = {0}, m = 0, mc = 0, i, empties, extras;
    
    for (i = 0; i < tasksSize; ++i) {
        ++count[tasks[i] - 'A'];
        
        if (m == count[tasks[i] - 'A'])
            ++mc;
        else if (m < count[tasks[i] - 'A']) {
            m = count[tasks[i] - 'A'];
            mc = 1;
        }
    }

    empties = (m - 1) * (n - mc + 1);
    extras = tasksSize - m * mc;
    return tasksSize + max(0, empties - extras);
}
