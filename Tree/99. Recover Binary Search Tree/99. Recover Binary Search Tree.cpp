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
    TreeNode* first = NULL;
    TreeNode* second = NULL;
    TreeNode* lastSeen = new TreeNode(INT_MIN);
public:
    void recoverTree(TreeNode* root) {
        inorder(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
    void inorder(TreeNode* root) {
        // corner case
        if (root == NULL) return;
        inorder(root->left);
        // ....
        if (root->val < lastSeen->val) {
            if (first == NULL) {
                first = lastSeen;
            }
            second = root;
        }
        lastSeen = root;
        inorder(root->right);
    }
};
