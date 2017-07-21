import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode curr;
        
        if (root == null)
            return ret;
        
        queue.add(root);
        queue.add(null);
        while (! queue.isEmpty()) {
            if ((curr = queue.poll()) != null) {
                if (queue.peek() == null)
                    ret.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            } else {
                if (queue.isEmpty())
                    break;
                else
                    queue.add(null);
            }
        }
        
        return ret;
    }
}
