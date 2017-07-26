import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret;
        Deque<Integer> deque = new LinkedList<Integer>();
        int count = 0, i;
        
        if (k <= 0)
            return new int[0];
        ret = new int[nums.length - k + 1];
        
        for (i = 0; i < nums.length; ++i) {
            if ((! deque.isEmpty()) && deque.peekFirst() <= i - k)
                deque.pollFirst();
            
            while ((! deque.isEmpty()) && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            
            deque.addLast(i);
            
            if (i >= k - 1)
                ret[count++] = nums[deque.peekFirst()];
        }
        
        return ret;
    }
}
