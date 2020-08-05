class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int n = nodes;
        int[] numChild = new int[n], cnt = new int[n];
        Arrays.fill(cnt, 1);
        for (int i = 0; i < n; i++) {
            if (parent[i] != - 1) numChild[parent[i]]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // leaf node
            if (numChild[i] == 0) {
                q.add(i);
                if (value[i] == 0) cnt[i] = 0;
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int p = parent[cur];
            if (p == -1) continue;
            numChild[p]--;
            value[p] += value[cur];
            cnt[p] += cnt[cur];
            if (numChild[p] == 0) {
                q.add(p);
                if (value[p] == 0) cnt[p] = 0;
            }
        }
        return cnt[0];
    }
}
