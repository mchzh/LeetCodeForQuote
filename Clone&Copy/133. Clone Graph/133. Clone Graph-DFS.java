class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        // hashmap
        if (node == null) return node;
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        // next loop
        for (Node next : node.neighbors) {
            if (map.containsKey(next)) {
                newNode.neighbors.add(map.get(next));
            } else {
                newNode.neighbors.add(cloneGraph(next));
            }
        }
        return newNode;
    }
}
