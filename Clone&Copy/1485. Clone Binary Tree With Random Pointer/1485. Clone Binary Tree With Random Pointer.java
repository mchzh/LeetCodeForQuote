class Solution {
    // stream
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<>();
        dfs(root, map);
        // connect every new node
        return connect(root, map);
    }
    private void dfs(Node node, Map<Node, NodeCopy> map) {
        if (node == null) return;
        
        map.putIfAbsent(node, new NodeCopy(node.val));
        //if (node.random != null) System.out.println(node.random.val);
        dfs(node.left, map);
        dfs(node.right, map);
        //dfs(node.random, map);
    }
    
    private NodeCopy connect(Node node, Map<Node, NodeCopy> map) {
        if (node == null) return null;
        
        // divide & conquer
        NodeCopy newNode = map.getOrDefault(node, null);
        NodeCopy left = connect(node.left, map);
        NodeCopy right = connect(node.right, map);
        //NodeCopy random = connect(node.random, map);
        newNode.left = left;
        newNode.right = right;
        //newNode.random = random;
        newNode.random = map.get(node.random);
        //System.out.println(node.left.val);
        return newNode;
    }
}
