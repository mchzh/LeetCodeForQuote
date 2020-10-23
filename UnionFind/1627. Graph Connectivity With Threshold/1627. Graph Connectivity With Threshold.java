class Solution {
    int[] parent;
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int k = threshold+1; k <= n; k++) {
            for (int x = k; x <= n; x += k) {
                union(x, k);
            }
        }
        
        // next part : check two points from queries
        List<Boolean> rets = new ArrayList<>();
        for (int[] q : queries) {
            if ( find(q[0]) == find(q[1]) ) {
                rets.add(true);
            } else {
                rets.add(false);
            }
        }
        return rets;
    }
    
    private int find(int x) {
        if ( x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
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

// for (any x) {
//     for (any y) {
//         for (k > threshold && k < n) {
//             if (x % k == 0 && y % k == 0) {
//                 union(x, y);
//             }
//         }
//     }
// }
// O(pow(10,4) * pow(10, 4) * n) == 10 8 O(n2)
    
// for (int k = threshold+1; k <= n; k++) {
//     for (int x = k; x < n; x += k) {
//         union(x, k);
//     }
// }
// k : 1 ... n
// inner: k ... n -> k, k+k, ... mk == n => N/k

// N/1 + N/2 +.... + N/N = N*(1 + 1/2 +....+1/N) = O(nlogn)
