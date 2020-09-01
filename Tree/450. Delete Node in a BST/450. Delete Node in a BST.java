class Solution {
    // https://leetcode.com/problems/delete-node-in-a-bst/discuss/93296/Recursive-Easy-to-Understand-Java-Solution
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) root = root.left;
            else if (root.left == null) root = root.right;
            else {
                TreeNode rightMin = getMinOfRight(root.right);
                root.val = rightMin.val;
                root.right = deleteNode(root.right, rightMin.val);
                // on left tree, find the right-most element
//                 int leftMax = getMaxOfLeft(root.left);

//                 if (root.left.val != leftMax) {
//                     root.val = leftMax;
//                 } else {
//                     TreeNode rightMin = getMinOfRight(root.right);
//                     root.val = rightMin.val;
//                     root.right = deleteNode(root.right, rightMin.val);
//                 }
            }
        }
        return root;
    }
    private int getMaxOfLeft(TreeNode node) {
        TreeNode prev = node;
        while (node.right != null) {
            prev = node;
            node = node.right;
        }
        if (prev != node) prev.right = null;
        return node.val;
    }
    private TreeNode getMinOfRight(TreeNode node) {
        TreeNode prev = node;
        while (node.left != null) {
            prev = node;
            node = node.left;
        }
        //if (prev != node) prev.left = null;
        return node;
    }
}

//     5
//    / \
//   3() 6
//  / \   \
// 2   4   7
// find the right most element of left subtree; if not exist, directly delete this node, connect right node to parent
