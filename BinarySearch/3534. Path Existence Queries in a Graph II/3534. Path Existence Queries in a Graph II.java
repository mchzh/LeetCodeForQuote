class Solution {
    int[][] up = new int[100001][18];
    private int setstep(int u, int step) {
        for (int i = 0; i <= 17; i++) {
            if (((step>>i)&1) == 1) {
                u = up[u][i];
            }
        }
        return u;
    }

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // sort
        int[][] infos = new int[n][2];
        for (int i = 0; i < n; i++) {
            infos[i][0] = nums[i];
            infos[i][1] = i;
        }
        Arrays.sort(infos, (a, b) -> (a[0] - b[0]));
        // map new idx with old idx
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[infos[i][1]] = i; // map current sorted idx as original sequence
        }

        // create up[][0] with two point;
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r < n && (infos[r][0]- infos[i][0]) <= maxDiff) {
                r++;
            }
            up[i][0] = r-1;
        }
        // set up[u][k] from up[u][0]
        for (int k = 1; k <= 17; k++) {
            for (int u = 0; u < n; u++) {
                up[u][k] = up[up[u][k-1]][k-1];
            }
        }

        // loop query with binary search to query
        int m = queries.length;
        int[] rets = new int[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            if (q[0] == q[1]) {
                rets[i] = 0;
                continue;
            }
            // get map point
            int u = idx[q[0]], v = idx[q[1]];
            
            if (u > v) {
                // swap
                int temp = u;
                u = v;
                v = temp;
            }

            int low = 1, high = 100000;
            while (low < high) {
                int mid = low + (high-low)/2;
                int k = setstep(u, mid);
                // k is prior v
                if (infos[k][0] >= infos[v][0]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            int k = setstep(u, low);
             if (infos[k][0] >= infos[v][0]) {
                    rets[i] = low;
                } else {
                    rets[i] = -1;
                }
        }
        return rets;
    }
}

// up[u][k] = up[up[u][k-1]][k-1];
// ........
// l .... l1 .... l2
