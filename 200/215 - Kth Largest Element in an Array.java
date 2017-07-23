import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> curr, left, right, mid;
        int pivot, pCount;
        
        curr = new ArrayList<Integer>();
        left = new ArrayList<Integer>();
        right = new ArrayList<Integer>();
        
        for (int num : nums)
            curr.add(num);
        
        while (true) {
            left.clear();
            right.clear();
            pCount = 0;
            
            pivot = curr.get(curr.size() / 2);
            for (Integer num : curr) {
                if (num > pivot)
                    left.add(num);
                else if (num < pivot)
                    right.add(num);
                else
                    pCount++;
            }
            
            if (left.size() >= k) {
                curr = new ArrayList<Integer>(left);
            } else {
                if (left.size() + pCount >= k)
                    return pivot;
                else {
                    k -= left.size() + pCount;
                    curr = new ArrayList<Integer>(right);
                }
            }
        }
    }
}
