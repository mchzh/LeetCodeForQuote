class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            // deal current node;
            TreeNode cur = stack.pop();
            if (prev != null && prev.val >= cur.val) return false;
            prev = cur;
            root = cur.right;
        }
        return true;
    }
}
