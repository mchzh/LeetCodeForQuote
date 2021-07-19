class Solution {
    // https://docs.google.com/presentation/d/1qTqae2_F_-of6euQ8GICMsIIw3UZk7nWm9dQLIQjhLs/edit#slide=id.gb30fce9fb9_0_0
    // 1707 -> dfs + backtrace
    class TrieNode {
        TrieNode[] next;
        int count;
        public TrieNode() {
            count = 0;
            next = new TrieNode[2];
        }   
    }
    TrieNode root = new TrieNode();
    // child graph
    Map<Integer, List<Integer>> graph = new HashMap<>();
    // query list
    Map<Integer, List<int[]>> query = new HashMap<>();
    int[] rets;
    int treeroot = 0;
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = parents.length;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) treeroot = i;
            graph.computeIfAbsent(parents[i], k -> new ArrayList<>()).add(i);
        }
        // handel queries
        int m = queries.length;
        for (int i = 0; i < m; i++) {
            int[] cut = queries[i];
            query.computeIfAbsent(cut[0], k -> new ArrayList<>()).add(new int[] {cut[1], i});
        }
        
        rets = new int[m];
        dfs(treeroot); // with backtrace
        return rets;
    }
    private void dfs(int start)  {
        //TrieNode curroot = root;
        addVal(root, start);
        //System.out.println((root==null) + " " + start);
        if (query.containsKey(start)) {
            for (int[] q : query.get(start)) {
                int val = q[0];
                int idx = q[1];
                //System.out.println(val + " " + idx);
                rets[idx] = getmaxans(root, val);
            }
        }
        
        
        if (graph.containsKey(start)) {
            for (int next : graph.get(start)) {
                dfs(next);
            }
        }
        delVal(root, start);
    }
    
    private void addVal(TrieNode node, int num) {
        TrieNode curroot = node;
        for (int i = 31; i >= 0; i--) {
            if (curroot.next[(num>>i)&1] == null) {
                curroot.next[(num>>i)&1] = new TrieNode();
            }
            curroot = curroot.next[(num>>i)&1];
            curroot.count++;
        }
        //System.out.println(curroot.count + " " + (curroot == null));
    }
    private void delVal(TrieNode node, int num) {
        TrieNode curroot = node;
        for (int i = 31; i >= 0; i--) {
            curroot = curroot.next[(num>>i)&1];
            curroot.count--;
        }
    }
    private int getmaxans(TrieNode node, int num) {
        TrieNode curroot = node;
        if (curroot.next[0] == null && curroot.next[1]== null) return -1;
        if (curroot.next[0].count == 0 && curroot.next[1].count == 0) return -1;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            //System.out.println("node -> " + i + " " + num + " " + (curroot.next[0]==null) + " " + (curroot.next[1]==null) );
            if (curroot.next[1-((num>>i)&1)] != null && curroot.next[1-((num>>i)&1)].count > 0) {
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
