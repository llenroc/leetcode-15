class Solution {
    public int findIntegers(int num) {
        String s = Integer.toBinaryString(num);
        int len = s.length();
        int ret = 0;
        int[] zero = new int[len], one = new int[len];
        zero[0] = 1;
        one[0] = 1;
        
        for (int i = 1; i < len; ++i) {
            zero[i] = zero[i - 1] + one[i - 1];
            one[i] = zero[i - 1];
        }
        ret = one[len - 1] + zero[len - 1];
        
        for (int i = 1; i < len; ++i) {
            char c = s.charAt(i), n = s.charAt(i - 1);
            
            if (c == '0' && n == '0') {
                ret -= one[len - i - 1];
            }
            
            if (c == '1' && n == '1') {
                break;
            }
        }
        
        return ret;
    }
}