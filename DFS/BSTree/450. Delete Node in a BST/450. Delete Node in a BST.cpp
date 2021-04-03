class Solution {
public:
    TreeNode* deleteNode(TreeNode* root, int key) {
        if (root == NULL) return NULL;
        
        if (key < root->val) {
            root->left = deleteNode(root->left, key);
        } else if (key > root->val) {
            root->right = deleteNode(root->right, key);
        } else {
            if (root->left == NULL) root = root->right;
            else if (root->right == NULL) root = root->left;
            else {
                root->val = minOfRight(root->right);
                root->right = deleteNode(root->right, root->val);
            }
        }
        
        return root;
    }
    int minOfRight(TreeNode* node) {
        while (node-> left != NULL) node = node->left;
        return node->val;
    }
};
