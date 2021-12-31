/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int rets = 0;
    int maxAncestorDiff(TreeNode* root) {
        if (root == NULL) return rets;
        dfs(root);
        return rets;
    }
    
    pair<int, int> dfs(TreeNode* node) {
        if (node == NULL) return {INT_MIN, INT_MAX};
        
        pair<int, int> left = dfs(node->left);
        pair<int, int> right = dfs(node->right);
        int cur = node->val;
        if (left.first != INT_MIN && left.second != INT_MAX) {
            rets = max(rets, max(abs(cur-left.first), abs(cur-left.second)));
        }
        
        if (right.first != INT_MIN && right.second != INT_MAX) {
            rets = max(rets, max(abs(cur-right.first), abs(cur-right.second)));
        }
        
        return {max(cur, max(left.first, right.first)), min(cur, min(left.second, right.second))};
    }
};
