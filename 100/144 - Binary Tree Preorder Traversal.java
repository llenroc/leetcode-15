import java.util.ArrayList;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (curr != null || ! stack.empty()) {
            if (curr == null)
                curr = stack.pop();
            ret.add(curr.val);
            if (curr.right != null)
                stack.push(curr.right);
            curr = curr.left;
        }
        
        return ret;
    }
}
