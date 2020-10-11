class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        //dfs
        if (original == null) return original;
        return dfs(original, cloned, target);
    }
    private TreeNode dfs( TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        TreeNode left = dfs(original.left, cloned.left, target);
        TreeNode right = dfs(original.right, cloned.right, target);
        if (left == null) return right;
        else return left;
    }
}

/*class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if( original == null)
            return null;
        
        if( original == target){
            return cloned;
        }
        TreeNode one = getTargetCopy(original.left,cloned.left,target);
        if( one != null)
            return one;
        TreeNode two =getTargetCopy(original.right,cloned.right,target);
        return two;
    }
    

}*/
