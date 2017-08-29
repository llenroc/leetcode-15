import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int i;
        double[] ret = new double[nums.length - k + 1];
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(Collections.reverseOrder()), right = new PriorityQueue<Integer>();
        
        for (i = 0; i <= nums.length; ++i) {
            if (i >= k) {
                if (left.size() == right.size())
                    ret[i - k] = ((double)left.peek() + (double)right.peek()) / 2.0;
                else
                    ret[i - k] = (double)left.peek();
                
                if (ret[i - k] >= nums[i - k])
                    left.remove(nums[i - k]);
                else
                    right.remove(nums[i - k]);
            }
            
            if (i < nums.length) {
                if ((! left.isEmpty()) && left.peek() >= nums[i])
                    left.offer(nums[i]);
                else
                    right.offer(nums[i]);
                
                while (left.size() < right.size())
                    left.offer(right.poll());
                
                while (left.size() > right.size() + 1)
                    right.offer(left.poll());
            }
        }
        
        return ret;
    }
}
