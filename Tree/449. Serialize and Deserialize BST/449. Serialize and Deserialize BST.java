/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    private void dfs(TreeNode node, StringBuilder sb) {
        // base case
        if (node == null) return;
        sb.append(node.val);
        sb.append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] strs = data.split(",");
        
        return helper(strs, 0, strs.length-1);
    }
    private TreeNode helper(String[] strs, int left, int right) {
        // base case
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(Integer.valueOf(strs[left]));
        }
        int val = Integer.valueOf(strs[left]);
        TreeNode root = new TreeNode(val);
        int rightStart = -1;
        for (int i = left+1; i <= right; i++) {
            int cur = Integer.valueOf(strs[i]);
            if (cur < val) continue;
            else if (cur > val) {
                rightStart = i;
                break;
            }
        }
        root.left = helper(strs, left+1, rightStart == -1 ? right : rightStart-1);
        root.right = helper(strs, rightStart, rightStart == -1 ? rightStart-1 : right);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
