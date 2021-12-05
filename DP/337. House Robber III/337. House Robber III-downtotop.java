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
    public int rob(TreeNode root) {
        int[] rets = dfs(root);
        return Math.max(rets[0], rets[1]);
    }
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[] {0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] rets = new int[2];
        rets[0] = node.val + left[1] + right[1]; // rob node
        rets[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // not rob node
        return rets;
    }
}
