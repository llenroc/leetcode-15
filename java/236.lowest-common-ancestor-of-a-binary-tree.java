/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 *
 * autogenerated using scripts/convert.py
 */
import java.util.Deque;
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> path1, path2;
        TreeNode ret;
        
        path1 = findPath(root, p);
        path2 = findPath(root, q);
        
        do {
            ret = path1.pollFirst();
            path2.pollFirst();
        } while ((! path1.isEmpty()) && (! path2.isEmpty() && path1.peekFirst() == path2.peekFirst()));
        
        return ret;
    }
    
    private Deque<TreeNode> findPath(TreeNode root, TreeNode target) {
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        TreeNode peek = null, prev = null;
        
        while (root != null || ! deque.isEmpty()) {
            while (root != null) {
                deque.addLast(root);
                root = root.left;
            }
            
            peek = deque.peekLast();
            
            if (peek.right != null && prev != peek.right)
                root = peek.right;
            else {
                if (target == peek)
                    break;
                prev = deque.pollLast();
            }
        }
        
        return deque;
    }
}
