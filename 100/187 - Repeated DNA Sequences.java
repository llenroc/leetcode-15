import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> ret = new HashSet<String>();
        HashSet<Integer> set = new HashSet<Integer>();
        int i, sub = 0x0, three_mask = 0x7, sub_mask = ~((1 << 31) >> 1);
        for (i = 0; i < s.length(); ++i) {
            sub = ((sub << 3) | ((int)(s.charAt(i)) & three_mask)) & sub_mask;

            if (set.contains(sub))
                ret.add(s.substring(i - 9, i + 1));
            else
                set.add(sub);
        }
        
        return new ArrayList<String>(ret);
    }
}
