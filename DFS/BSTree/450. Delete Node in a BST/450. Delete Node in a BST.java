class Solution {
    // recusive
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else {
                root.val = minOfRight(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        
        return root;
    }
    private int minOfRight(TreeNode node) {
        while (node.left != null) node = node.left;
        return node.val;
    }
}
// three scenario
// 1. leaf node;
// 2. has only one child;
// 3. has two children;
