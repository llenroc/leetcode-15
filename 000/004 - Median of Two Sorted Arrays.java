class Solution {
    
    public int findKth(int[] nums1, int[] nums2, int from1, int len1, int from2, int len2, int k) {
  
        if (len1 == 0) {
            return nums2[from2 + k - 1];
        }
        
        if (len2 == 0) {
            return nums1[from1 + k - 1];
        }
        
        int mid1 = len1 / 2, mid2 = len2 / 2;
        
        if (nums1[from1 + mid1] <= nums2[from2 + mid2]) {
            if (k > mid1 + mid2 + 1) {
                return findKth(nums1, nums2, from1 + mid1 + 1, len1 - mid1 - 1, from2, len2, k - mid1 - 1);
            } else {
                return findKth(nums1, nums2, from1, len1, from2, mid2, k);
            }
        } else {
            if (k > mid1 + mid2 + 1) {
                return findKth(nums1, nums2, from1, len1, from2 + mid2 + 1, len2 - mid2 - 1, k - mid2 - 1);
            } else {
                return findKth(nums1, nums2, from1, mid1, from2, len2, k);
            }
        }
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, k = (len1 + len2) / 2;
        
        if ((len1 + len2) % 2 != 0) {
            return (double) findKth(nums1, nums2, 0, len1, 0, len2, k + 1);
        } else {
            return ((double) findKth(nums1, nums2, 0, len1, 0, len2, k + 1) + (double) findKth(nums1, nums2, 0, len1, 0, len2, k)) / 2.0;
        }
    }
}