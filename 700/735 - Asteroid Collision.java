import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
                continue;
            }
            
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(a);
                    break;
                }
                
                int top = stack.peek();
                
                if (top < 0) {
                    stack.push(a);
                    break;
                } else if (top > -a) {
                    break;
                } else {
                    stack.pop();
                    
                    if (top == -a) {
                        break;
                    }
                }
            }
        }
        
        int len = stack.size();
        int[] ret = new int[len];
        
        for (int i = 0; i < len; ++i) {
            ret[len - i - 1] = stack.pop();
        }
        
        return ret;
    }
}