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
    // https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45648/three-ways-of-iterative-postorder-traversing-easy-explanation
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.peek();
                if (!visited.contains(root)) {
                    visited.add(root);
                    root = root.right;
                } else {
                    ret.add(root.val);
                    stack.pop();
                    root = null;
                }
            }
        }
        return ret;
    }
    public List<Integer> postorderTraversalRough(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.peek();
                System.out.println(cur.val);
                if (pre != null) System.out.println("pre node -> " + pre.val);
                if (cur.right == null || cur.right == pre) {
                    ret.add(cur.val);
                    stack.pop();
                    pre = cur;
                    root = null;
                    continue;
                }
                root = cur.right;
            }
        }
        return ret;
    }
}

// stack : 5 
// ret: (...) (...) 5
    
//        5
//     /    \
//     3     4
//     /
//     2
//    /  \
//  null  1
