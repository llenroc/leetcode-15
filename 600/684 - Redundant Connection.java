class Solution {
    private int findRoot(int[] root, int curr) {
        while (root[curr] != -1) {
            curr = root[curr];
        }
        
        return curr;
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int[] root = new int[2001];
        for (int i = 0; i < 2001; ++i) {
            root[i] = -1;
        }
        
        for (int[] edge : edges) {
            int f = findRoot(root, edge[0]), s = findRoot(root, edge[1]);
            if (f == s) {
                return edge;
            }
            
            root[s] = f;
        }
        
        return null;
    }
}