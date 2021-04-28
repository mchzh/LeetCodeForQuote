class Solution {
    Node head = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        inorder(root);
        
        head.left = last;
        last.right = head;
        return head;
    }
    private void inorder(Node node) {
        if (node == null) return;
        
        inorder(node.left);
        if (head == null) head = node;
        if (last != null) {
            last.right = node;
            node.left = last;
        }
        last = node;
        inorder(node.right);
    }
}
