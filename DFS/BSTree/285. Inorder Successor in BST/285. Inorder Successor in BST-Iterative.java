class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if (cur == p) {
                prev = cur;
            } else if (prev != null) return cur;
            root = cur.right;
        }
        return null;
    }
}
