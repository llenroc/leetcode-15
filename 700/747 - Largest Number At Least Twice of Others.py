class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mi, m = 0, nums[0]
        for i, k in enumerate(nums):
            if k > m:
                m = k
                mi = i
        return mi if all(m == k or m >= 2 * k for k in nums) else -1