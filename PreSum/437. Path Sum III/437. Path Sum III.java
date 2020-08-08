class Solution {
    // hashmap + presum
    // two sum issue
    // recursively call the current path
    // on the curreent path to use presum
    int ret = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> presum = new HashMap<>();
        presum.put(0, 1);
        // dfs(root, sum);
        // return ret;
        return dfsPresum(root, sum, 0, presum);
    }
    private int dfsPresum(TreeNode node, int sum, int curSum, Map<Integer, Integer> presum) {
        if (node == null) return 0;
        int ret = 0;
        curSum += node.val;
        ret += presum.getOrDefault(curSum-sum, 0);
        presum.put(curSum, presum.getOrDefault(curSum, 0) + 1);
        ret += dfsPresum(node.left, sum, curSum, presum) + dfsPresum(node.right, sum, curSum, presum);
        presum.put(curSum, presum.get(curSum) - 1);
        return ret;
    }
    private void dfs(TreeNode node, int sum) {
        if (node == null) return;
        int[] count = new int[1];
        findPath(node, sum, count, 0);
        ret += count[0];
        dfs(node.left, sum);
        dfs(node.right, sum);
    }
    private void findPath(TreeNode node, int sum, int[] count, int curSum) {
        if (node == null) return;
        curSum += node.val;
        if (curSum == sum) count[0]++;
        findPath(node.left, sum, count, curSum);
        findPath(node.right, sum, count, curSum);
    }
}

//       10
//      /  \
//     5   -3
//    / \    \
//   3   2   11
// (3, 3+3,3+-2) (2,2+0,2+1) (11, 11+0, 11+0)
//  / \   \
// 3  -2   1
// (3, 3+0, 3+0) (-2, -2+0, -2+0) (1, 1, 1)
