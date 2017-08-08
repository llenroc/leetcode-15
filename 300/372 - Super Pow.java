public class Solution {
    public int superPow(int a, int[] b) {
        int ret = 1;
        
        for (int c : b)
            ret = pow(ret, 10) * pow(a, c) % 1337;
        
        return ret;
    }
    
    private int pow(int x, int e) {
        int half;
        
        if (e == 0)
            return 1;
        if (e == 1)
            return x % 1337;
        
        
        return pow(x % 1337, e / 2) * pow(x % 1337, e - e / 2) % 1337;
    }
}
