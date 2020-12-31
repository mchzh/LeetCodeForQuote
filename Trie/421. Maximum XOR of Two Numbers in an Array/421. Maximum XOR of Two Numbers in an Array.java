class Solution {
    // trie
    // positive
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        // create trie
        for (int n : nums) {
            TrieNode cur  = root;
            for (int k = 31; k >= 0; k--) {
                if (cur.node[n>>k&1] == null) {
                    cur.node[n>>k&1] = new TrieNode();
                }
                cur = cur.node[n>>k&1];
            }
        }
        
        // find trie with element
        int rets = 0;
        for (int n : nums) {
            TrieNode cur  = root;
            int ans = 0;
            for (int k = 31; k >= 0; k--) {
                //System.out.println( (cur.node[1-(n>>k&1)] == null ? "null" :  cur.node[1-(n>>k&1)]) + "" + cur.node[(n>>k&1)]);
                if (cur.node[1-(n>>k&1)] != null) {
                    ans = ans*2 + 1;
                    cur = cur.node[1-(n>>k&1)];
                } else {
                    ans = ans*2 + 0;
                    cur = cur.node[n>>k&1];
                }
            }
            rets = Math.max(rets, ans);
        }
        return rets;
    }
    
    class TrieNode {
        TrieNode[] node;
        public TrieNode() {
            node = new TrieNode[2];
        }
    }
}


// 001010111001
// 110101000110 flip is target

// 1XXXXXXXXX
// 1XXXXXXXXX

// 1XXXXXXXXX
// 1XXXXXXXXX
