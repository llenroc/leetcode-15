/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 *
 * autogenerated using scripts/convert.py
 */
import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxCount;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        int[] ret;
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        maxCount = 0;
        
        helper(root, hm, temp);
        
        ret = new int[temp.size()];
        for (Integer t : temp)
            ret[count++] = t;
        
        return ret;
    }
    
    private int helper(TreeNode root, HashMap<Integer, Integer> hm, ArrayList<Integer> temp) {
        int sum, count;
        
        if (root == null)
            return 0;
        
        sum = helper(root.left, hm, temp) + helper(root.right, hm, temp) + root.val;
        
        if (hm.containsKey(sum))
            hm.replace(sum, hm.get(sum) + 1);
        else
            hm.put(sum, 1);
        
        count = hm.get(sum);
        if (count >= maxCount) {
            if (count > maxCount)
                temp.clear();
            temp.add(sum);
            maxCount = count;
        }
        
        return sum;
    }
}
