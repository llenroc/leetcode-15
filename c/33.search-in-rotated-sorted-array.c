/*
 * @lc app=leetcode id=33 lang=c
 *
 * [33] Search in Rotated Sorted Array
 *
 * autogenerated using scripts/convert.py
 */
int search(int* nums, int numsSize, int target) {
    int start = 0, end = numsSize - 1, mid;
    
    while (start < end - 1) {
        mid = (start + end) / 2;
        if (nums[start] < nums[mid]) {
            if (target <= nums[mid] && target >= nums[start]) {
                end = mid;
            } else {
                start = mid;
            }
        } else {
            if (target >= nums[mid] && target <= nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
    }
    
    if (nums[start] == target) {
        return start;
    } else if (nums[end] == target) {
        return end;
    } else {
        return -1;
    }
}
