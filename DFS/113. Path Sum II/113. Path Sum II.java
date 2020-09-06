/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // dfs + backtracing
    // time complixity: O(N2)
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // dfs
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        List<Integer> list = new ArrayList<>();
        dfs(root, ret, sum, list);
        return ret;
    }
    private void dfs(TreeNode node, List<List<Integer>> ret, int sum, List<Integer> list) {
        if (node == null) return;
        if (sum - node.val == 0 && node.left == null && node.right == null) {
            list.add(node.val);
            ret.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        sum -= node.val;
        list.add(node.val);
        dfs(node.left, ret, sum, list);
        list.remove(list.size()-1);
        list.add(node.val);
        dfs(node.right, ret, sum, list);
        list.remove(list.size()-1);
    }
}

/*class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        List<Integer> cur = new ArrayList<Integer>();
        
        
        
        helper(root, sum, result, cur);
        
        return result;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> cur){
        if(root == null) return;
        cur.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum)
                result.add(new LinkedList<>(cur));
        }
        
        if(root.left != null){
            helper(root.left, sum - root.val, result, cur);
        }
        if(root.right != null){
            helper(root.right, sum - root.val, result, cur);
        }
        
        cur.remove(cur.size() - 1);
    }
}*/
