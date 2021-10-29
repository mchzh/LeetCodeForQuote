class Solution {
    // map + tree
    class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    long rets = 0;
    int count = 0;
    long global = 0;
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        int[][] tree = new int[n][3];
        for (int[] t : tree) Arrays.fill(t, -1);
        for (int i = 1; i < n; i++) {
            int par = parents[i];
            if (tree[par][0] == -1) tree[par][0] = i;
            else tree[par][1] = i;
        }
        // for (int i = 0; i < n; i++) {
        //     if (tree[i][0] == -1 && tree[i][1] == -1) tree[i][2] = -2;
        //     System.out.println("tree element -> " + i +  " " + tree[i][0] + " " + tree[i][1] + " " + tree[i][2]);
        // }
        global = n;
//         // create tree
//         // System.out.println(global);
//         Node root = new Node(0);
//         map.put(0, root);
//         for (int i = 1; i < n; i++) {
//             int par = parents[i];
        
//             if (map.containsKey(i)) {
//                 Node child = map.get(i);
//                 if (map.containsKey(par)) {
//                     Node parent = map.get(par);
//                     if (parent.left == null) parent.left = child;
//                     else parent.right = child;
//                 } else {
//                     Node newparentnode = new Node(par);
//                     newparentnode.left = child;
//                     map.put(par, newparentnode);
//                 }
//             } else {
//                 Node newnode = new Node(i);
//                 if (map.containsKey(par)) {
//                     Node parent = map.get(par);
//                     if (parent.left == null) parent.left = newnode;
//                     else parent.right = newnode;
//                 } else {
//                     Node newparentnode = new Node(par);
//                     newparentnode.left = newnode;
//                     map.put(par, newparentnode);
//                 }
//                 map.put(i, newnode);
//             }
//         }
        
        // tranver the tree
        // dfs
        //System.out.println(root.val);
        dfs(0, tree);
        //System.out.println("last -> " + dfs(root));
        return count;
    }
    
    private long dfs(int pos, int[][] tree) {
        //System.out.println("recursion start -> " + pos +  " " + tree[pos][0] + " " + tree[pos][1]);
        if (pos == -1) return 0;
        
        // divide
        //System.out.println(node.val);
        
        //System.out.println("start -> " + pos +  " " + tree[pos][0] + " " + tree[pos][1]);
        long left = dfs(tree[pos][0], tree); // if is not long with int  the below case is 17
        long right = dfs(tree[pos][1], tree);
        //System.out.println(pos + " " + left + " " + right);
        // conquer
        long parent = global-(left+right+1);
        long product = (left == 0 ? 1 : left) * (right == 0 ? 1 : right) * (parent == 0 ? 1 : parent);
        //System.out.println(left + " " + right + " " + global + " " + product);
        if (product > rets) {
            count = 1;
            rets = product;
        } else if (product == rets) {
            count++;
        }
        return left+right+1;
    }
}
