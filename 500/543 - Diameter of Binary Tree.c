static inline int max(int a, int b) {
    return a > b ? a : b;
}

static int helper(struct TreeNode *root, int *ret_p) {
    int left, right;
    
    if (! root)
        return 0;
    
    left = helper(root->left, ret_p);
    right = helper(root->right, ret_p);
    
    *ret_p = max(*ret_p, left + right);
    return max(left, right) + 1;
}

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int diameterOfBinaryTree(struct TreeNode* root) {
    int ret = 0;
    
    helper(root, &ret);
    
    return ret;
}
