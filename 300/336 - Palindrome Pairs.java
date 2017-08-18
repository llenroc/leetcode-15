import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashMap;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        TreeSet<Integer> set = new TreeSet<Integer>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int i, len;
        String rev;
        
        for (i = 0; i < words.length; ++i) {
            hm.put(words[i], i);
            set.add(words[i].length());
        }
        
        for (i = 0; i < words.length; ++i) {
            rev = new StringBuilder(words[i]).reverse().toString();
            len = rev.length();
            
            if (hm.containsKey(rev) && hm.get(rev) != i)
                addToRet(hm, i, rev, ret, true);
            
            for (int p : set.headSet(len)) {
                if (isPalindrome(rev, 0, len - p - 1) && hm.containsKey(rev.substring(len - p)))
                    addToRet(hm, i, rev.substring(len - p), ret, true);
                
                if (isPalindrome(rev, p, len - 1) && hm.containsKey(rev.substring(0, p)))
                    addToRet(hm, i, rev.substring(0, p), ret, false);
            }
        }
        
        return ret;
    }
    
    private void addToRet(HashMap<String, Integer> hm, int index, String str, List<List<Integer>> ret, boolean indexFirst) {
        List<Integer> temp = new ArrayList<Integer>(2);
        
        if (indexFirst) {
            temp.add(index);
            temp.add(hm.get(str));
        } else {
            temp.add(hm.get(str));
            temp.add(index);
        }
        
        ret.add(temp);
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        
        return true;
    }
}
