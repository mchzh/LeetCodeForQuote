class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // two stack
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> rets = new ArrayList<>();
        if (root == null) return rets;
        
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                rets.add(0, root.val);
                stack.push(root);
                root = root.right;
            } else {
                TreeNode cur = stack.pop();
                root = cur.left;
            }
        }
        
        return rets;
    }
}
