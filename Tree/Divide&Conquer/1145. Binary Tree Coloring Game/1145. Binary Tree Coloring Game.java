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
    // https://leetcode.com/problems/binary-tree-coloring-game/discuss/350570/JavaC%2B%2BPython-Simple-recursion-and-Follow-Up
    // three area count number
    int leftS = 0, rightS = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        subTreeNum(root, x);
        int parentNum = n-leftS -rightS-1;
        return Math.max(parentNum, Math.max(leftS, rightS)) > n/2; // n is odd
    }
    private int subTreeNum(TreeNode node, int x) {
        if (node == null) return 0;
        int left = subTreeNum(node.left, x);
        int right = subTreeNum(node.right, x);
        if (node.val == x) {
            leftS = left;
            rightS = right;
        }
        return left + right + 1;
    }
}


  // |  P |
  // |    |     X
  // |    | \ L \    \R\  
