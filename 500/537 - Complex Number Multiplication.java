import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public String complexNumberMultiply(String a, String b) {
        int ar, ai, br, bi, r = 0, i = -5;
        Pattern p = Pattern.compile("^(-?[0-9]+)\\+(-?[0-9]+)i$");
        Matcher m;
        
        m = p.matcher(a);
        m.find();
        ar = Integer.valueOf(m.group(1));
        ai = Integer.valueOf(m.group(2));
        m = p.matcher(b);
        m.find();
        br = Integer.valueOf(m.group(1));
        bi = Integer.valueOf(m.group(2));
            
        return String.format("%d+%di", ar * br - ai * bi, ar * bi + ai * br);
    }
}
