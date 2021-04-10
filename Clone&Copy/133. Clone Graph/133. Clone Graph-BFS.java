class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        q.offer(node);
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node next : cur.neighbors) {
                if (!map.containsKey(next)) {
                    map.put(next, new Node(next.val, new ArrayList<>()));
                    q.offer(next);
                }
                map.get(cur).neighbors.add(map.get(next));
            }
        }
        return map.get(node);
    }
}
