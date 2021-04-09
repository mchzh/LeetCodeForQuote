class Solution {
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) node = node.left;
            return node;
        } else {
            if (node.parent == null) return null;
            if (node.parent.val > node.val) {
                return node.parent;
            } else {
                while (node.parent != null && node.parent.val < node.val) {
                    node = node.parent;
                }
                return node.parent;
            }
        }
    }
}
