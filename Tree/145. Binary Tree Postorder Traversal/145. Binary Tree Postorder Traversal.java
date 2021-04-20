class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rets = new ArrayList<>();
        if (root == null) return rets;
        Set<TreeNode> crossright = new HashSet<>();
        
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.peek();
                if (!crossright.contains(cur)) { // first time to cross right tree
                    crossright.add(cur);
                    root = cur.right;
                } else { // second time to read this node
                    rets.add(cur.val);
                    stack.pop();
                    root = null; // avoid the endless loop
                }
            }
        }
        return rets;
    }
}
