class Solution {
    class SumNode {
        int maxsingle;
        int maxcurrent;
        public SumNode(int single, int current) {
            this.maxsingle = single;
            this.maxcurrent = current;
        }
    }
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        //TreeNode rets = dfs(root).maxcurrent;
        return dfs(root).maxcurrent;
    }
    private SumNode dfs(TreeNode node) {
        if (node == null) return new SumNode(0, Integer.MIN_VALUE);
        
        int val = node.val;
        SumNode left = dfs(node.left);
        SumNode right = dfs(node.right);
        
        int cur_maxsingle = Math.max(left.maxsingle, right.maxsingle)+val;
        cur_maxsingle = Math.max(cur_maxsingle, 0);
        int cur_maxcurrent = Math.max(left.maxsingle+val+right.maxsingle, Math.max(left.maxcurrent, right.maxcurrent));
        //cur_maxcurrent = Math.max(cur_maxcurrent, val);
        return new SumNode(cur_maxsingle, cur_maxcurrent);
    }
}
