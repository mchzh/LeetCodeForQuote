class Solution {
    // dfs + backtracking
    // time complixity: O(N2)
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // dfs
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        List<Integer> list = new ArrayList<>();
        dfs(root, ret, sum, list);
        return ret;
    }
    private void dfs(TreeNode node, List<List<Integer>> ret, int sum, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (sum - node.val == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(list));
        }
        dfs(node.left, ret, sum-node.val, list);
        dfs(node.right, ret, sum-node.val, list);
        list.remove(list.size()-1);
    }
}
