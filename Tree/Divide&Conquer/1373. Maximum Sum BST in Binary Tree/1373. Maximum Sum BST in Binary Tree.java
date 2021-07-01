class Solution {
    // consider 98 Validate Binary Search Tree - https://leetcode.com/problems/validate-binary-search-tree/
    class Node {
        boolean isBst;
        int sum;
        int max;
        int min;
        public Node(int sum, boolean isBst, int max, int min) {
            this.sum = sum;
            this.isBst = isBst;
            this.max = max;
            this.min = min;
        }
    }
    int rets = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return rets;
    }
    private Node dfs(TreeNode node, int max, int min) {
        if (node == null) {
            return new Node(0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Node left = dfs(node.left, Math.min(node.val, max), min);
        Node right = dfs(node.right, max, Math.max(node.val, min));
        
        int cursum = node.val + left.sum + right.sum;
        boolean isCurBst = left.isBst && right.isBst && (node.val > left.max && node.val < right.min);
        if (isCurBst) rets = Math.max(rets, cursum);
        return new Node(cursum, isCurBst, Math.max(node.val, Math.max(left.max, right.max)), Math.min(node.val, Math.min(left.min, right.min)));
    }
}
