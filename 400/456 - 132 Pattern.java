import java.util.Stack;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE, i;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < third)
                return true;
            else {
                while ((! stack.empty()) && nums[i] > stack.peek())
                    third = stack.pop();
            }
            stack.push(nums[i]);
        }
        
        return false;
    }
}
