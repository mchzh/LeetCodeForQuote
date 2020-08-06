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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        // divide & conquer
        return dfs(nums, 0, nums.length-1);
    }
    private TreeNode dfs(int[] nums, int left, int right) {
        if (right < left) return null;
        
        // find the cur pos of max val
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = left; i <= right; i++) {
            if (max > nums[i]) continue;
            max = nums[i];
            idx = i;
        }
        //System.out.println();
        TreeNode leftNode = dfs(nums, left, idx-1);
        TreeNode rightNode = dfs(nums, idx+1, right);
        // conquer
        TreeNode root = new TreeNode(nums[idx]);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
