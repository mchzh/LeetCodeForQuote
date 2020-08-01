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
    // divide & conquer
    class NodeInfo {
        TreeNode node;
        int nodeNum;
        public NodeInfo() {
            this.node = null;
            this.nodeNum = 0;
        }
        public NodeInfo(TreeNode node, int num) {
            this.node = node;
            this.nodeNum = num;
        }
    }
    
    public TreeNode recoverFromPreorder(String S) {

        // pre handle
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            // get val and depth
            int j = i;
            while (j < S.length() && S.charAt(j) == '-') {
                j++;
            }
            int depth = j-i;
            i = j;
            while ( j < S.length() && Character.isDigit(S.charAt(j)) ) {
                j++;
            }
            int val = Integer.valueOf(S.substring(i, j));
            list.add(new int[] {val, depth});
            i = j-1;
        }
        
        return dfs(0, list).node;
    }
    private NodeInfo dfs(int cur, List<int[]> list) {
        // basecase
        int[] visitingNode = list.get(cur);
        TreeNode root = new TreeNode(visitingNode[0]);
        NodeInfo left = new NodeInfo();
        if (cur+1 < list.size() && visitingNode[1] +1 == list.get(cur+1)[1]) {
            left = dfs(cur+1, list);
        }
            

        int rightPos = cur+left.nodeNum+1;
        NodeInfo right = new NodeInfo();;
        if (rightPos < list.size() && visitingNode[1] +1 == list.get(rightPos)[1]) {
            right = dfs(rightPos, list);
        }
            
        
        // handl node info
        root.left = left.node;
        root.right = right.node;
        NodeInfo curNode = new NodeInfo(root, left.nodeNum+right.nodeNum+1);
        return curNode;
    }
}

// node[]: 
// 1 0
// 2 1
// 3 2
// 4 2
// 5 1
// 6 2
// 7 2
    
//     If a node has only one child, that child is guaranteed to be the left child
