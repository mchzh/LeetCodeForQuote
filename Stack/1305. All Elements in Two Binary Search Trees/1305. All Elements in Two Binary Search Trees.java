class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        while (!stack1.isEmpty() || !stack2.isEmpty() || root1 != null || root2 != null) {
            if (root1 != null || root2 != null) {
                if (root1 != null) {
                    stack1.push(root1);
                    root1 = root1.left;
                } 
                if (root2 != null) {
                    stack2.push(root2);
                    root2 = root2.left;
                }
            } else {
                if (!stack1.isEmpty() && !stack2.isEmpty()) {
                    TreeNode cur1 = stack1.peek();
                    TreeNode cur2 = stack2.peek();

                    if (cur1.val <= cur2.val) {
                        ret.add(cur1.val);
                        root1 = stack1.pop();
                        root1 = root1.right;
                    } else {
                        ret.add(cur2.val);
                        root2 = stack2.pop();
                        root2 = root2.right;
                    }
                } else if (!stack1.isEmpty()) {
                    root1 = stack1.pop();
                    ret.add(root1.val);
                    root1 = root1.right;
                } else {
                    root2 = stack2.pop();
                    ret.add(root2.val);
                    root2 = root2.right;
                }
                
            }
        }
        
        return ret;
    }
}
