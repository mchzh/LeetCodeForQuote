class Solution {
    List<TreeNode> parent = new ArrayList<>();
    List<Integer> rets = new ArrayList<>();
    Set<TreeNode> visited = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return rets;
        if (k == 0) {
            rets.add(target.val);
            return rets;
        }
        List<TreeNode> path = new ArrayList<>();
        dfs(root, target, path);

        // get the child node with distance K
        //dfsc(target.left, k, 1, target);
        //dfsc(target.right, k, 1, target);
        //dfsc(target, k, 0);

        //for (TreeNode p : parent) System.out.println(p.val);
        // get the paret node with distance K
        for (int i = 0; i < parent.size(); i++) {
            if (i > k) break;
            TreeNode cur = parent.get(i);
            //System.out.println(cur.val);
            dfsc(cur, k, i);
        }
        return rets;
    }
    
    void dfs(TreeNode node, TreeNode target, List<TreeNode> path) {
        if (node == null) return;
        //if (node ) return;
        if (node == target) {
            parent.add(target);
            for (int i = path.size()-1; i >= 0; i--) parent.add(path.get(i));
            return;
        }
        path.add(node);
        dfs(node.left, target, path);
        dfs(node.right, target, path);
        path.remove(path.size()-1);
    }
    
    void dfsc(TreeNode node, int dep, int lev) {
        if (node == null) return;
        if (visited.contains(node)) return;
        if (lev == dep) {
            rets.add(node.val);
            return;
        }
        visited.add(node);
        dfsc(node.left, dep, lev+1);
        dfsc(node.right, dep, lev+1);
    }
}
