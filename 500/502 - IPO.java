import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> cap = new PriorityQueue<int[]>((int[] p1, int[] p2) -> (p1[0] - p2[0]));
        PriorityQueue<int[]> pro = new PriorityQueue<int[]>((int[] p1, int[] p2) -> (p2[1] - p1[1]));
        int i;
        
        for (i = 0; i < Capital.length; ++i)
            cap.add(new int[]{Capital[i], Profits[i]});
        
        for (i = 0; i < k; ++i) {
            while ((! cap.isEmpty()) && cap.peek()[0] <= W)
                pro.offer(cap.poll());
            
            if (pro.isEmpty())
                break;
            
            W += pro.poll()[1];
        }
        
        return W;
    }
}
