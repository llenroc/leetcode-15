/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 *
 * autogenerated using scripts/convert.py
 */
import java.util.Queue;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int ret = 0;
        TreeNode curr;
        
        if (root == null)
            return 0;
        
        queue.add(root);
        
        while (! queue.isEmpty()) {
            curr = queue.poll();
            
            if (curr.left != null) {
                if (curr.left.left == null && curr.left.right == null)
                    ret += curr.left.val;
                else
                    queue.add(curr.left);
            }
            
            if (curr.right != null)
                queue.add(curr.right);
        }
        
        return ret;
    }
}
