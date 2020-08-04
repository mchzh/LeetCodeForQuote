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
    int ret = Integer.MIN_VALUE; // co-product
    public int maxPathSum(TreeNode root) {
        maxDownPath(root);
        return ret;
    }
    private int maxDownPath(TreeNode node) {
        if (node == null) return 0;
        
        int leftSum = maxDownPath(node.left);
        int rightSum = maxDownPath(node.right);
        
        int maxTurn = node.val;
        if (leftSum >= 0) maxTurn += leftSum;
        if (rightSum >= 0) maxTurn += rightSum;
        ret = Math.max(ret, maxTurn);
        if (leftSum < 0 && rightSum < 0)  {
            return node.val;
        } else {
            return node.val + Math.max(leftSum, rightSum);
        }
    }
}

// MaxPath(node, Asturn) -> node.val + max(0, MaxPath(leftNode, noTurn)) + max(0, MaxPath(rightNode, noTurn))
