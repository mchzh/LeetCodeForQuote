class Solution {
    // record sel and non-sel two status
    public int rob(TreeNode root) {
        // int result = Math.max(robFrom(root), robNext(root));
        // return result;
        int[] rets = helper(root);
        return Math.max(rets[0], rets[1]);
    }
    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = node.val + left[0] + right[0];
        return res;
    }
    private int robFrom(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return node.val + robNext(node.left) + robNext(node.right);
    }
    
    private int robNext(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return rob(node.left) + rob(node.right);
    }
}
