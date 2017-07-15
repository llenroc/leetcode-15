static int helper(struct TreeNode *root, int prev) {
    int local = prev * 10 + root->val, ret = 0;
    
    if (! (root->left || root->right))
        return local;
    
    if (root->left)
        ret += helper(root->left, local);
    
    if (root->right)
        ret += helper(root->right, local);
    
    return ret;
}

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int sumNumbers(struct TreeNode* root) {
    if (! root)
        return 0;
    return helper(root, 0);
}
