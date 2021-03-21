class Solution {
    // sort + trie
    class TrieNode {
        TrieNode[] next;
        public TrieNode() {
            next = new TrieNode[2];
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        // sort array and query
        TrieNode root = new TrieNode();
        int n = queries.length;
        int m = nums.length;
        Arrays.sort(nums);
        int[][] sortedquery = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedquery[i][0] = queries[i][0];
            sortedquery[i][1] = queries[i][1];
            sortedquery[i][2] = i;
        }
        Arrays.sort(sortedquery, (a, b) -> ( a[1]-b[1] ));
        int[] rets = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int[] cur = sortedquery[i];
            while (idx < m && nums[idx] <= cur[1]) {
                inserttrie(root, nums[idx]);
                idx++;
            }
            // get max ans
            rets[cur[2]] = getmaxans(root, cur[0]);
        }
        return rets;
    }
    private void inserttrie(TrieNode node, int num) {
        TrieNode curroot = node;
        for (int i = 31; i >= 0; i--) {
            if (curroot.next[(num>>i)&1] == null) {
                curroot.next[(num>>i)&1] = new TrieNode();
            }
            curroot = curroot.next[(num>>i)&1];
        }
    }
    private int getmaxans(TrieNode node, int num) {
        TrieNode curroot = node;
        if (curroot.next[0] == null && curroot.next[1]== null) return -1;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if (curroot.next[1-((num>>i)&1)] != null) {
                curroot = curroot.next[1-((num>>i)&1)];
                ans = ans*2+1;
            } else {
                curroot = curroot.next[(num>>i)&1];
                ans = ans*2+0;
            }    
        }
        return ans;
    }
}
