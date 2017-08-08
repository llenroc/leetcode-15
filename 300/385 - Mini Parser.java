/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger ret;
        int br, i, from;
        char c;
        
        if (s.length() == 0)
            return new NestedInteger();
        
        if (s.charAt(0) != '[')
            return new NestedInteger(Integer.parseInt(s));
    
        if (s.length() < 3)
            return new NestedInteger();
        
        ret = new NestedInteger();
        from = 1;
        br = 0;
        for (i = 1; i < s.length(); ++i) {
            c = s.charAt(i);
            
            if (br == 0 && (c == ',' || i == s.length() - 1)) {
                ret.add(deserialize(s.substring(from, i)));
                from = i + 1;
            } else if (c == '[')
                ++br;
            else if (c == ']')
                --br;
        }
        
        return ret;
    }
}
