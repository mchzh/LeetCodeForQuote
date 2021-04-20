class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rets = new ArrayList<>();
        if (root == null) return rets;
        
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                rets.add(0, root.val);
                stack.push(root);
                root = root.right;
            }
            TreeNode cur = stack.pop();
            root = cur.left;
        }
        return rets;
    }
}
