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
    int rets = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return rets;
        dfs(root);
        return rets;
    }
    private int[] dfs(TreeNode node) {
        int[] cur = new int[4];
        if (node == null) return cur;

        
        Arrays.fill(cur, 1);
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // single increasing
        if (node.left != null && node.left.val == node.val + 1) {
            cur[0] = Math.max(cur[0], left[0]+1);
        }
        if (node.right != null && node.right.val == node.val + 1) {
            cur[0] = Math.max(cur[0], right[0]+1);
        }
        // single decreasing
        if (node.left != null && node.left.val == node.val - 1) {
            cur[1] = Math.max(cur[1], left[1]+1);
        }
        if (node.right != null && node.right.val == node.val - 1) {
            cur[1] = Math.max(cur[1], right[1]+1);
        }
        // left decresing and right increasing
        if (node.left != null && node.right != null 
            && node.left.val == node.val - 1
            && node.right.val == node.val + 1) {
            cur[2] = Math.max(cur[2], left[1]+right[0]+1);
        }
        // left increasing and right decreasing
        if (node.left != null && node.right != null 
            && node.left.val == node.val + 1
            && node.right.val == node.val - 1) {
            cur[3] = Math.max(cur[3], left[0]+right[1]+1);
        }

        for (int c : cur) {
            rets = Math.max(rets, c);
        }
        return cur;
    }
}
//[increase len, decrease len, middle len: left i right d, left d, rihgt i]
