import java.util.Stack;

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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr, prev = null, temp = null, first = null, second = null;
        int val;
        
        curr = root;
        while (curr != null || ! stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null) {
                if (first == null) {
                    if (curr.val <= prev.val) {
                        first = prev;
                        temp = curr;
                    }
                } else if (second == null) {
                    if (curr.val <= prev.val) {
                        second = curr;
                        break;
                    }
                }
            }
            prev = curr;
            curr = curr.right;
        }
        
        if (second == null)
            second = temp;
        
        val = first.val;
        first.val = second.val;
        second.val = val;
    }
}
