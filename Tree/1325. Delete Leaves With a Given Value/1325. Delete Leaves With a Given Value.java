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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return root;
        return dfs(root, target);
    }
    private TreeNode dfs(TreeNode node, int target) {
        if (node == null) return null;
        
        TreeNode left = dfs(node.left, target);
        TreeNode right = dfs(node.right, target);
        if (left == null && right == null && node.val == target) {
            return null;
        } else {
            node.left = left;
            node.right = right;
            return node;
        }
    }
}
