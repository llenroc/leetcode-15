/*
 * @lc app=leetcode id=124 lang=c
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * autogenerated using scripts/convert.py
 */
#include <limits.h>

#define max(a, b) ((a) > (b) ? (a) : (b))

static int helper(struct TreeNode *root, int *ret_p) {
    int left_best, right_best;
    
    if (! root)
        return 0;
    left_best = helper(root->left, ret_p);
    right_best = helper(root->right, ret_p);
    
    *ret_p = max(*ret_p, left_best + right_best + root->val);
    return max(0, root->val + max(left_best, right_best));
}

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int maxPathSum(struct TreeNode* root) {
    int ret = INT_MIN;
    
    helper(root, &ret);
    
    return ret;
}
