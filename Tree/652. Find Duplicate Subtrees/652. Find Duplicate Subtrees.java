class Solution {
    // seriliza and hash
    Map<String, Integer> key2Id = new HashMap<>();
    Map<String, Integer> key2Count = new HashMap<>();
    List<TreeNode> rets = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getId(root);
        return rets;
    }
    private int getId(TreeNode node) {
        if (node == null) return -1;
        
        String key = String.valueOf(node.val) + "#" + String.valueOf(getId(node.left)) + "#"
            + String.valueOf(getId(node.right));
        
        if (!key2Id.containsKey(key)) {
            key2Id.put(key, key2Id.size());
            //key2Count.put(key, );
        } else {
            key2Count.put(key, key2Count.getOrDefault(key, 0)+1);
            if (key2Count.get(key) == 1) rets.add(node);
        }
        
        return key2Id.get(key);
    }
}

//1#(2#4)#(3#(2#(4))#(4))
