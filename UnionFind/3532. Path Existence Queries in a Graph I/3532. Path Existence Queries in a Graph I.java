class Solution {
    int[] parent;
    // union find and slide window
    // union find for connection area
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int cur = nums[left];
            while (right < nums.length && nums[right]-cur <= maxDiff) {
                union(left, right);
                right++;
            }
            // move left
            if (right -left > 1) {
                right--;
                left = right;
            }      
        }

        int len = queries.length;
        boolean[] rets = new boolean[len];
        for (int i = 0; i < len; i++) {
            int[] p = queries[i];
            int a = find(p[0]);
            int b = find(p[1]);
            rets[i] = (a==b);
        }
        return rets;
    }
    private int find(int a) {
        if (a != parent[a]) parent[a] = find(parent[a]);
        return parent[a];
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
