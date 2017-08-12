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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(',');
        if (root == null)
            sb.append('#');
        else {
            sb.append(root.val);
            sb.append(serialize(root.left));
            sb.append(serialize(root.right));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>();
        
        for (String s : data.split(",")) {
            if (s.length() > 0)
                queue.add(s);
        }
        
        return helper(queue);
    }
    
    private TreeNode helper(Queue<String> queue) {
        int i;
        String s;
        TreeNode ret;
        
        if (queue.isEmpty())
            return null;
        s = queue.poll();
        
        if (s.equals("#"))
            return null;
        else {
            ret = new TreeNode(Integer.valueOf(s));
            ret.left = helper(queue);
            ret.right = helper(queue);
        }
        
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
