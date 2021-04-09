class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return dfs(root, p, null);
    }
    private TreeNode dfs(TreeNode node, TreeNode tar, TreeNode parent) {
        if (node == null) return null;
        if (node == tar) {
            if (node.right != null) {
                node = node.right;
                while (node.left != null) node = node.left;
                return node;
            } else return parent;
        } else {
            if (node.val > tar.val) return dfs(node.left, tar, node);
            else return dfs(node.right, tar, parent);
        }
    }
}
