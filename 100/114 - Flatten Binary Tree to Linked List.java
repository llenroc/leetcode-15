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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        TreeNode leftLeaf, rightLeaf;
        
        if (root == null)
            return null;
        
        leftLeaf = helper(root.left);
        rightLeaf = helper(root.right);
        
        if (leftLeaf != null) {
            leftLeaf.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        
        if (rightLeaf != null)
            return rightLeaf;
        if (leftLeaf != null)
            return leftLeaf;
        return root;
    }
}
