class Solution {
    int ret = INT_MIN;
public:
    int maxPathSum(TreeNode* root) {
        MaxDownPath(root);
        return ret;
    }
    int MaxDownPath(TreeNode* node) {
        if (node == NULL) return 0;
        
        int leftSum = MaxDownPath(node->left);
        int rightSum = MaxDownPath(node->right);
        
        int maxTurnSum = node->val;
        if (leftSum >= 0) maxTurnSum += leftSum;
        if (rightSum >= 0) maxTurnSum += rightSum;
        ret = max(ret, maxTurnSum);
        
        return max(0, max(leftSum, rightSum)) + node->val;
    }
};
