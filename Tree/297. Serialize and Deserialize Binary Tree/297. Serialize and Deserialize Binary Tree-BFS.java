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
    // BFS
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur != null) {
                q.offer(cur.left);
                q.offer(cur.right);
                sb.append(cur.val);
                sb.append(",");
            } else {
                sb.append("#");
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<TreeNode> list = new ArrayList<>();
        for (String s : strs) {
            if (s.equals("#")) {
                list.add(null);
            } else {
                list.add(new TreeNode(Integer.valueOf(s)));
            }
        }
        // two pointer for this list
        // left : for current node
        // rihgt: for two child left and right: j and j+1
        int i = 0, j = 1;
        while (j < list.size()) {
            TreeNode node = list.get(i);
            if (node != null) {
                node.left = list.get(j);
                node.right = list.get(j+1);
                j += 2;
            }
            i++;
        }
        return list.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
