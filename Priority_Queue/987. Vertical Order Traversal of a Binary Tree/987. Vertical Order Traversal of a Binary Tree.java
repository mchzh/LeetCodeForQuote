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
    // bfs or dfs
    class Node {
        TreeNode curNode;
        int x, y;
        public Node(TreeNode node, int x, int y) {
            this.curNode = node;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            Node visitN = queue.poll();
            int hor = visitN.x, ver = visitN.y;
            map.computeIfAbsent(hor, k -> new PriorityQueue<int[]>( (a, b) -> ( a[2]==b[2] ? a[0] - b[0] : a[2] - b[2]) )).add(new int[] {visitN.curNode.val, hor, ver});
            max = Math.max(max, hor);
            min = Math.min(min, hor);
            if (visitN.curNode.left != null) queue.offer(new Node(visitN.curNode.left, hor-1, ver+1));
            if (visitN.curNode.right != null) queue.offer(new Node(visitN.curNode.right, hor+1, ver+1));
        }
        for (int i = min; i <= max; i++) {
            PriorityQueue<int[]> pq = map.get(i);
            List<Integer> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                list.add(pq.poll()[0]);
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
