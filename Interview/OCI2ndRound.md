// Provide the diameter of a binary tree.
//.          4
//        4     9
//     5.   9
//            10
//               11
//.          4
//        4     9
//     5.   9       10
//            10        20
//               11         30

// null 
//     4
//    4
//   4  -> 0 or 2 (from leaf node to root)

//   3
// 1    4

//         4
//      5      30
//    1   10
//  2    11
//          20
// 1. dfs to find all lead node save them into hashmap
// 2. select any two lead node, then find the nearest common parent node - 
// root -> 4
// left height -> left subtree -> 4 
// right height -> right subtree -> 1
// currheirght : max(left, right) -> 4 + 1 == 5
// diameter: left + right
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    public static void main(String[] args) {
        
    }
    
    int diameter = 0;
    public int diameterOfTree(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        // divide & conquer
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
