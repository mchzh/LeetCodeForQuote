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
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>>paths;
        vector<int>path;
        
        dfs(root, sum, paths, path);
        return paths;
    }
    void dfs(TreeNode* node, int sum, vector<vector<int>>& paths, vector<int>& path) {
        if (!node) return;
        path.push_back(node->val);
        if ( !(node->left) && !(node->right) && sum == node->val) {
            paths.push_back(path);
            //return;
        }
        dfs(node->left, sum - node->val, paths, path);
        dfs(node->right, sum - node->val, paths, path);
        path.pop_back();
    }
};
