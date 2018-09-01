bool isIdealPermutation(int* A, int ASize) {
    int m = ASize;
    
    for (int i = ASize - 1; i >= 2; --i) {
        m = m > A[i] ? A[i] : m;
        if (m < A[i - 2]) {
            return 0;
        }
    }
    return 1;
}