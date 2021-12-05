/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // dfs + memo
    Map<TreeNode, Integer> map1 = new HashMap<>();
    Map<TreeNode, Integer> map2 = new HashMap<>();
    public int rob(TreeNode root) {
        return Math.max(dfs(root, 1), dfs(root, 0));
    }
    private int dfs(TreeNode node, int flag) {
        if (node == null) return 0;
        
        int rets = 0;
        if (flag == 1) {
            if (map1.containsKey(node)) return map1.get(node);
            rets =  node.val + dfs(node.left, 0) + dfs(node.right, 0);
        } else {
            if (map2.containsKey(node)) return map2.get(node);
            rets = Math.max(dfs(node.left, 0), dfs(node.left, 1)) + Math.max(dfs(node.right, 0), dfs(node.right, 1)); // node non-select
        }
        
        if (flag == 1) map1.put(node, rets);
        else map2.put(node, rets);
        return rets;
    }
}
