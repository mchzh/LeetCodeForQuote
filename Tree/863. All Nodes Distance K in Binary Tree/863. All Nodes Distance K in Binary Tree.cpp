class Solution {
public:
    vector<int>rets;
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        dfs(root, target, k);
        return rets;
    }
    int dfs(TreeNode* node, TreeNode* target, int k) {
        if (node == NULL) {
            return -1;
        }
        if (node == target) {
            fetch(node, k);
            return 0;
        }
        
        int depth1 = dfs(node->left, target, k);
        if (depth1 != -1) { // left tree witho target
            if (depth1 == k-1) {
                rets.push_back(node->val);
            } else {
                fetch(node->right,k-depth1-2);
            }
            return depth1+1;
        }
        
        int depth2 = dfs(node->right, target, k);
        if (depth2 != -1) { // left tree with target
            if (depth2 == k-1) {
                rets.push_back(node->val);
            } else {
                fetch(node->left, k-depth2-2);
            }
            return depth2+1;
        }
        
        return -1;
    }
    
    void fetch(TreeNode* node, int k) {
        if (node == NULL) return;
        if (k < 0) return;
        if (k == 0) {
            rets.push_back(node->val);
            return;
        }
        fetch(node->left, k-1);
        fetch(node->right, k-1);
    }
};
