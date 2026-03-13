class Solution {
    // binar search + union find + MST
    int[] parent;
    public int maxStability(int n, int[][] edges, int k) {
        parent = new int[n];
        

        int lo = 1, hi = (int)1e5*2;
        while (lo < hi) {
            int mid = hi - (hi-lo)/2;
            if (isOk(mid, n, edges, k)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        
        //System.out.println(lo + " : " + (isOk(lo, n, edges, k)));
        if (isOk(lo, n, edges, k)) {
            return lo;
        } else {
            return -1;
        }
    }

    public boolean isOk(int T, int n, int[][] edges, int k) {
        List<int[]> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) parent[i] = i;

        int count = 0;
        int upgrade = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 1) {
                if (s < T) return false;
                union(u, v);
                count++;
            } else {
                if (s >= T) {
                    candidates.add(new int[]{0, u, v});
                }
                if (2*s >= T) {
                    candidates.add(new int[]{1, u, v});
                }
            }
        }
        //System.out.println(count);

        // sort candidates
        if (candidates != null && candidates.size() != 0) Collections.sort(candidates, (a, b) -> (a[0]-b[0]));

        // every valid candidates union
        for (int[] can : candidates) {
            int u = can[1], v = can[2];
            if (count == n-1) break;
            if (find(u) != find(v)) {
                // union connection
                union(u, v);
                count++;
                upgrade += can[0];
                if (upgrade > k) return false;
            }
        }

        // find to check every point belong to the same parent
        for (int i = 0; i < n; i++) {
            if (find(0) != find(i)) return false;
        }

        return count==n-1;
    }

    private void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);

        if (rootx < rooty) {
            parent[rooty] = rootx;
        } else {
            parent[rootx] = rooty;
        }
    }

    private int find(int x) {
        //System.out.println("parent idx : " + x);
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}

// T:  the minimum strength score among all edges included in it.
// must 1 : s >= T
// must 0 : s >= T
//         2*s >= T
