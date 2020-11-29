class Solution {
    public Node flipBinaryTree(Node root, Node leaf) {
        if (root == null) return root;
        
        Node node = leaf;
        Node parent = null;
        while (node != root) {
            //corner case: [1,2,null,3,null,4,null,5,null,6]
            // every node is a parent of next element -> list chain
            Node temp = node.parent;
            if (node.left != null && node.left != parent) {
                node.right = node.left;      
            }
            
            node.left = node.parent;
            node.parent = parent;
            parent = node;
            node = temp;
        }
        
        // handle last node -> root
        if (node.left != null && node.left == parent) {
            node.left = null;      
        }
        if (node.right != null && node.right == parent) {
            node.right = null;      
        }
        node.parent = parent;
        return leaf;
        // helper(root, leaf);
        // return leaf;
    }
    private void dfs(Node node) {
        if (node == null) return;
        if (node.parent != null) System.out.println("parent -> " + node.parent.val);
        System.out.println("cur node -> " + node.val);
        dfs(node.left);
        dfs(node.left);
    }
}
