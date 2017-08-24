int singleNonDuplicate(int* nums, int numsSize) {
    int left = 0, right = numsSize - 1, mid;
    
    while (left < right) {
        mid = left + (right - left) / 2;
        
        if (mid % 2) {
            if (nums[mid] == nums[mid - 1])
                left = mid + 1;
            else
                right = mid;
        } else {
            if (nums[mid] == nums[mid + 1])
                left = mid + 2;
            else
                right = mid;
        }
    }
    
    return nums[left];
}
