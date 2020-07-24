class Solution {
    // flip is to first go right then left when dfs
    List<Integer> flipped;
    int idx;
    int[] voyage;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        flipped = new ArrayList<>();
        idx = 0;
        this.voyage = voyage;
        
        dfs(root);
        
        //if () {}
        
        return flipped;
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val != voyage[idx++]) {
            flipped.clear();
            flipped.add(-1);
            return;
        }
        
        if (idx < voyage.length && root.left != null && root.left.val != voyage[idx]) {
            flipped.add(root.val);
            
            dfs(root.right);
            dfs(root.left);
        } else {
            dfs(root.left);
            dfs(root.right);
        }
    }
}
/*class Solution {
    
    private int i;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        i = 0;
        List<Integer> result = new ArrayList<>();
        try {
            flip(root, result, voyage);
            return result;
        } catch (Exception e) {
            return Collections.singletonList(-1);
        }
    }
    
    private void flip(TreeNode node, List<Integer> result, int[] voyage) {
        if (node == null) {
            return;
        }
        
        if (node.val != voyage[i] || i >= voyage.length) {
            throw new RuntimeException("No solution");
        }
        i++;
        
        if (node.left != null) {
            if (node.left.val != voyage[i]) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                result.add(node.val);
            }
        }
        flip(node.left, result, voyage);
        flip(node.right, result, voyage);
    }
}*/
