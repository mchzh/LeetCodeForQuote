class Solution {
    public Node findRoot(List<Node> tree) {
        int xorsum = 0;
        for (Node t : tree) {
            xorsum ^= t.val;
            for (Node next : t.children) {
                xorsum ^= next.val;
            }
        }
        for (Node t : tree) {
            if (xorsum == t.val) return t;
        }
        return null;
    }
}

// XOR:
// A^A = 0
// A^B^A = A^A^B
// root node visit one time
// child node visit two times
