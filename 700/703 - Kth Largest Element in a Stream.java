import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> heap;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>(k);

        Arrays.sort(nums);
        
        for (int i = nums.length - 1; i >= 0 && this.heap.size() < k; --i) {
            this.heap.offer(nums[i]);
        }
    }
    
    public int add(int val) {
        if (this.heap.size() < k) {
            this.heap.offer(val);
        } else if (val > this.heap.peek()) {
            this.heap.poll();
            this.heap.offer(val);
        }
        
        return this.heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */