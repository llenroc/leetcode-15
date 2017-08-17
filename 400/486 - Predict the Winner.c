static int helper(int *nums, int sum1, int sum2, int from, int to, int who) {
    if (from > to)
        return sum1 >= sum2;
    if (from == to) {
        if (who == 1)
            return sum1 + nums[from] >= sum2;
        else 
            return sum2 + nums[from] > sum1;
    }
    
    if (who == 1)
        return (! helper(nums, sum1 + nums[from], sum2, from + 1, to, 2)) || (! helper(nums, sum1 + nums[to], sum2, from, to - 1, 2));
    else
        return (! helper(nums, sum1, sum2 + nums[from], from + 1, to, 1)) || (! helper(nums, sum1, sum2 + nums[to], from, to - 1, 1));
}

bool PredictTheWinner(int* nums, int numsSize) {
    return helper(nums, 0, 0, 0, numsSize - 1, 1);
}
