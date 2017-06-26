#define G(c) (c == '9' || c == '7' ? 4 : 3)

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
char** letterCombinations(char* digits, int* returnSize) {
    char **ret, *c = digits, *s, *base, curr;
    int len = 0, size = 1, i, j, k, l, group, step;
    char *d[8] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    while (*c) {
        size *= G(*c);
        ++len;
        ++c;
    }
    
    if (! len) {
        *returnSize = 0;
        return NULL;
    }
    
    s = (char *)malloc((len + 1) * size * sizeof(char));
    ret = (char **)malloc(size * sizeof(char *));
    for (i = 0; i < size; ++i) {
        ret[i] = s;
        s[len] = '\0';
        s += len + 1;
    }
    
    step = size;
    for (i = 0; i < len; ++i) {
        base = (char *)d[digits[i] - '2'];
        group = G(digits[i]);
        step /= group;
        for (j = 0; j < group; ++j) {
            curr = base[j];
            for (k = j * step; k < size; k += step * group) {
                for (l = 0; l < step; ++l) {
                    ret[k + l][i] = curr;
                }
            }
        }
    }

    *returnSize = size;
    return ret;
}
