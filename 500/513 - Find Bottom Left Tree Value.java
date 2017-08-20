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
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int len, ret = -1;
        TreeNode t;
        
        if (root == null)
            return 0;
        queue.add(root);
        
        while (! queue.isEmpty()) {
            len = queue.size();
            
            ret = queue.peek().val;
            
            while (len-- > 0) {
                t = queue.poll();
                if (t.left != null)
                    queue.add(t.left);
                if (t.right != null)
                    queue.add(t.right);
            }
        }
        
        return ret;
    }
}
