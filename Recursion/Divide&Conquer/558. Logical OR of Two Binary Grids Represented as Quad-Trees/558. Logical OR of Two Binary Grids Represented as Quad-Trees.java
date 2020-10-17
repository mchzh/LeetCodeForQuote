class Solution {
    // divide & conquer
    public Node intersect(Node quadTree1, Node quadTree2) {
        // base case
        if (quadTree1 == null) return quadTree2;
        if (quadTree2 == null) return quadTree1;
        if (quadTree1.isLeaf == true) {
            if (quadTree1.val == true) return quadTree1;
            else return quadTree2;
        }
        if (quadTree2.isLeaf == true) {
            if (quadTree2.val == true) return quadTree2;
            else return quadTree1;
        }
        // divide
        Node ntl = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node ntr = intersect(quadTree1.topRight, quadTree2.topRight);
        Node nbl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node nbr = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        // System.out.println(ntl.isLeaf + " : " + ntl.val);
        // System.out.println(ntl.isLeaf + " : " + ntl.val);
        // System.out.println(ntl.isLeaf + " : " + ntl.val);
        // System.out.println(ntl.isLeaf + " : " + ntl.val);
        Node root = new Node();
        // conquer
        if (ntl.isLeaf && ntr.isLeaf && nbl.isLeaf && nbr.isLeaf) {
            if (ntl.val == ntr.val && ntr.val == nbl.val && nbl.val == nbr.val) {
                root.isLeaf = true;
            } else {
                root.isLeaf = false;
                root.topLeft = ntl;
                root.topRight = ntr;
                root.bottomLeft = nbl;
                root.bottomRight = nbr;
            }
            root.val = ntl.val;
        } else {
            root.isLeaf = false;
            root.val = ntl.val;
            root.topLeft = ntl;
            root.topRight = ntr;
            root.bottomLeft = nbl;
            root.bottomRight = nbr;
        }
        return root;
    }
}

// base case
// divide -> four children node
// conquer -> all leaf and has same value return lead with val, other wise lead is 0, val is any
