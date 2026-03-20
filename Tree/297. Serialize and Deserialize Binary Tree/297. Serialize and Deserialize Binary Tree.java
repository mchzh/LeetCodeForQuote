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
    // pre order tranverse

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        // based on string to create node list
        String[] strs = data.split(",");
        int n = strs.length;
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = strs[i];
            if (s.equals("#")) {
                list.add(null);
            } else {
                //System.out.println(s);
                list.add(new TreeNode(Integer.valueOf(s)));
            }
        }
        // node1 -> node2;
        // dfs to create tree
        return dfs(list, 0);
    }
    private TreeNode dfs(List<TreeNode> list, int pos) {
        TreeNode node = list.get(pos);
        if (node == null) return null;
        TreeNode left = dfs(list, pos+1);
        int size = getNum(left);
        TreeNode right = dfs(list, pos+size+1);
        node.left = left;
        node.right = right;
        return node;
    }
    private int getNum(TreeNode node) {
        if (node == null) return 1;
        return 1 + getNum(node.left) + getNum(node.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// 1, 2, #, #, 3,4,#,#,5#,# (pre-order sequence)
