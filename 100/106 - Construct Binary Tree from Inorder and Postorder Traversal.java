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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length)
            return null;
        
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int inFrom, int inTo, int[] postorder, int postFrom, int postTo) {
        TreeNode root;
        int index = -1, i;
        
        if (inTo < inFrom || postTo < postFrom)
            return null;
        root = new TreeNode(postorder[postTo]);
        for (i = inFrom; i <= inTo; ++i) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        if (i < 0)
            return null;
        
        root.left = helper(inorder, inFrom, index - 1, postorder, postFrom, postFrom + (index - inFrom) - 1);
        root.right = helper(inorder, index + 1, inTo, postorder, postFrom + (index - inFrom), postTo - 1);
        
        return root;
    }
}
