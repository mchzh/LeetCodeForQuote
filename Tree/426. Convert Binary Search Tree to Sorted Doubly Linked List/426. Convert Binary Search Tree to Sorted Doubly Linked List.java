class Solution {
    // prev and cur node
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node dummy = new Node(0);
        Node prev = dummy;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                Node cur = stack.pop();
                root = cur.right;
                prev.right = cur;
                cur.left = prev;
                prev = cur;
            }
        }
        
        Node first = dummy.right;
        first.left = prev;
        prev.right = first;
        return first;
    }
}
