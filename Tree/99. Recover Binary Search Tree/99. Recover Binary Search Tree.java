class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode lastSeen = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        // .....
        if (lastSeen == null || root.val > lastSeen.val) {
            lastSeen = root;
        } else {
            if (first == null) {
                first = lastSeen;
                lastSeen = root;
                second = root;
            } else {
                second = root;
                return;
            }
        }
        inorder(root.right);
    }
}
