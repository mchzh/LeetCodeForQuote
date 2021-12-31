/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int rets = 0;
    public int maxAncestorDiff(TreeNode root) {
        // max min + recursion backtracking
        if (root == null) return rets;
        dfs(root);
        return rets;
    }
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE};
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int cur = node.val;
        if (left[0] != Integer.MIN_VALUE && left[1] != Integer.MAX_VALUE) {
            rets = Math.max(rets, Math.max(Math.abs(cur-left[0]), Math.abs(cur-left[1])));
        }
        
        if (right[0] != Integer.MIN_VALUE && right[1] != Integer.MAX_VALUE) {
            rets = Math.max(rets, Math.max(Math.abs(cur-right[0]), Math.abs(cur-right[1])));
        }
        
        return new int[] {Math.max(cur, Math.max(left[0], right[0])), Math.min(cur, Math.min(left[1], right[1]))};
    }
}
