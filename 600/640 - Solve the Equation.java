import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String temp;
        StringBuilder sb = new StringBuilder();
        Pattern p;
        Matcher m;
        int x = 0, c = 0;
        
        temp = split[1].replace('+', '#').replace('-', '+').replace('#', '-');
        if (split[0].charAt(0) != '-')
            sb.append('+');
        sb.append(split[0]);
        if (temp.charAt(0) != '+')
            sb.append('-');
        sb.append(temp);
        
        m = Pattern.compile("((\\+|\\-)([0-9]+)?(x)?)").matcher(sb.toString());
        
        while (m.find()) {
            temp = m.group();
            if (temp.charAt(temp.length() - 1) == 'x') {
                if (temp.length() > 2)
                    x += Integer.valueOf(temp.substring(0, temp.length() - 1));
                else
                    x += temp.charAt(0) == '+' ? 1 : -1;
            } else
                c -= Integer.valueOf(temp);
        }
        
        if (x == 0) {
            if (c == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }
        
        return String.format("x=%d", c / x);
    }
}
