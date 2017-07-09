import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> i_stack = new Stack<Integer>();
        Stack<Boolean> p_stack = new Stack<Boolean>();
        int i, l, prev, maxLen = 0, currLen;
        
        if (s == null)
            return 0;
          
        for (i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                i_stack.push(i);
                p_stack.push(true);
            } else {
                if (p_stack.empty() || p_stack.peek() == false) {
                    i_stack.push(i);
                    p_stack.push(false);
                } else {
                    i_stack.pop();
                    p_stack.pop();
                    if (i_stack.empty())
                        currLen = i + 1;
                    else
                        currLen = i - i_stack.peek();
                    maxLen = Math.max(maxLen, currLen);
                }
            }
        }
        
        return maxLen;
    }
}
