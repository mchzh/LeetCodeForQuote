class Solution {
    // recursive -> inorder -> iterative
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        boolean left = isValidBST(root.left);
        // deal the val
        if (prev != null && prev.val >= root.val) return false;
        prev = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
