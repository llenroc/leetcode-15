#define min(a, b) (a < b ? a : b)
#define max(a, b) (a > b ? a : b)
#define h height

int maxArea(int* height, int heightSize) {
    int l = 0, r = heightSize - 1, m = 0, c;
    while (l < r) {
        c = (r - l) * min(h[l], h[r]);
        m = max(m, c);
        if (h[l] < h[r])
            ++l;
        else if (h[l] > h[r])
            --r;
        else {
            ++l;
            --r;
        }
    }
    return m;
}