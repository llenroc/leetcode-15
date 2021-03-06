/*
 * @lc app=leetcode id=136 lang=c
 *
 * [136] Single Number
 *
 * autogenerated using scripts/convert.py
 */
int singleNumber(int* nums, int numsSize) {
    int ret = 0, i;
    
    for (i = 0; i < numsSize; ++i)
        ret ^= nums[i];
        
    return ret;
}
