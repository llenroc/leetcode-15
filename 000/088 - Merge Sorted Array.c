void merge(int* nums1, int m, int* nums2, int n) {
    int *p1, *p2, *insert;
    
    if (! nums1)
        return nums2;
    else if (! nums2)
        return nums1;
    insert = nums1 + (m + n - 1);
    p1 = nums1 + (m - 1);
    p2 = nums2 + (n - 1);
    
    while (p1 >= nums1 && p2 >= nums2) {
        if (*p1 > *p2)
            *insert-- = *p1--;
        else
            *insert-- = *p2--;
    }
    
    while (p1 >= nums1)
        *insert-- = *p1--;
    while (p2 >= nums2)
        *insert-- = *p2--;
}
