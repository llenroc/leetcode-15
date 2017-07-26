import java.util.ArrayList;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return helper(input, 0, input.length() - 1);
    }
    
    private List<Integer> helper(String input, int from, int to) {
        List<Integer> ret = new ArrayList<Integer>(), left, right;
        int i;
        char c;
        
        for (i = from; i <= to; ++i) {
            c = input.charAt(i);
            
            if (! Character.isDigit(c)) {
                left = helper(input, from, i - 1);
                right = helper(input, i + 1, to);
                
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '+':
                                ret.add(l + r);
                                break;
                            case '-':
                                ret.add(l - r);
                                break;
                            default:
                                ret.add(l * r);
                                break;
                        }
                    }   
                }
            }
        }
        
        if (ret.isEmpty())
            ret.add(Integer.valueOf(input.substring(from, to + 1)));
        
        return ret;
    }
}
