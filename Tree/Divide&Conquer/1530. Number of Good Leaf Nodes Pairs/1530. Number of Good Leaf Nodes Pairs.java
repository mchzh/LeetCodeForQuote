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
    int ret = 0;
    public int countPairs(TreeNode root, int distance) {
        //divide & conquer
        // use map to store the count number of leaf node for this node and the depth
        // depth will ensure the distance
        dfs(root, distance);
        return ret;
    }
    private Map<Integer, Integer> dfs(TreeNode node, int d) {
        Map<Integer, Integer> curRecord = new HashMap<Integer, Integer>();
        if (node == null) return curRecord;
        // leaf node
        if (node.left == null && node.right == null) {
            curRecord.put(0, 1);
            return curRecord;
        }
        // divide
        Map<Integer, Integer> l = dfs(node.left, d);
        Map<Integer, Integer> r = dfs(node.right, d);
        // conquer
        for (Map.Entry<Integer,Integer> entry : l.entrySet()) {
            curRecord.put(entry.getKey()+1, curRecord.getOrDefault(entry.getKey()+1, 0) + entry.getValue());
        }
        
        for (Map.Entry<Integer,Integer> entry : r.entrySet()) {
            curRecord.put(entry.getKey()+1, curRecord.getOrDefault(entry.getKey()+1, 0) + entry.getValue());
        }
        // calculate the distance
        
        for (Map.Entry<Integer,Integer> entry : l.entrySet()) {
            int disL = entry.getKey() + 1;
            for (Map.Entry<Integer,Integer> entry1 : r.entrySet()) {
                int disR = entry1.getKey() + 1;
                if ((disL + disR) <= d) ret += entry.getValue() * entry1.getValue();
            }
        }
        return curRecord;
    }
}
