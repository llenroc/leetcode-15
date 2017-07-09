import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        path = path + "/";
        Stack<String> stack = new Stack<String>();
        int prev = 0, i;
        String sub;
        
        if (path == null)
            return null;
        for (i = 1; i < path.length(); ++i) {
            if (path.charAt(i) == '/') {
                if (prev < i - 1) {
                    sub = path.substring(prev + 1, i);
                    if (sub.equals("..")) {
                        if (! stack.empty())
                            stack.pop();
                    }
                    else if (! sub.equals("."))
                        stack.push(sub);
                }
                prev = i;
            }
        }
        
        return "/" + String.join("/", stack);
    }
}
