class Solution {
    // consider it with 421. Maximum XOR of Two Numbers in an Array
    public int[] maximizeXor(int[] nums, int[][] queries) {
        // sort nums and queries with mi
        TrieNode root = new TrieNode();
        Arrays.sort(nums);
        List<int[]> queryList = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            queryList.add(new int[] {queries[i][0], queries[i][1], i});
        }
        Collections.sort(queryList, (a, b) -> (a[1]-b[1]));
        
        int[] rets = new int[queries.length];
        Arrays.fill(rets, -1);
        
        int len = nums.length;
        int idx = 0;
        for (int[] cur : queryList) {
            // add less than element into trie
            
            while (idx < len && nums[idx] <= cur[1]) {
                int addelement = nums[idx];
                //addIntoTrie(root);
                TrieNode addnode = root;
                for (int k = 31; k >= 0; k--) {
                    if (addnode.children[addelement>>k&1] == null) {
                        addnode.children[addelement>>k&1] = new TrieNode();
                    }
                    addnode = addnode.children[addelement>>k&1];
                }
                idx++;
            }
            // find the largest one
            if (idx == 0) {
                continue;
            }
            int ans = 0;
            TrieNode node = root;
            for (int k = 31; k >= 0; k--) {
                if (node.children[1-(cur[0]>>k&1)] != null) {
                    ans = ans * 2 + 1;
                    node = node.children[1-(cur[0]>>k&1)];
                } else {
                    ans = ans * 2 + 0;
                    node = node.children[cur[0]>>k&1];
                }
            }
            rets[cur[2]] = ans;
        }
        return rets;
    }
    class TrieNode {
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[2];
        }
    }
}
