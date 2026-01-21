class Solution {
    // union find
    // 1 -> count++, four direction has '1', parent not same union two then count--;
    //int[] parent;
    private void union(int x, int y, int[] parent) {
        int rootx = find(x, parent);
        int rooty = find(y, parent);

        if (rootx < rooty) {
            parent[rooty] = rootx;
        } else {
            parent[rootx] = rooty;
        }
    }

    private int find(int x, int[] parent) {
        //System.out.println("parent idx : " + x);
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        List<Integer> rets = new ArrayList<>();
        int[] parent = new int[m*n];
        int count = 0;
        Arrays.fill(parent, -1);

        for (int[] p : positions) {
            int x = p[0];
            int y = p[1];
            int idx = x*n + y;
            if (parent[idx] == -1) {
                parent[idx] = idx;
            count++;
            }
            //System.out.println(x + " : " + y + " : " + count);
            // four neibour direction
            for (int k = 0; k < 4; k++) {
                int cx = x + dirs[k][0];
                int cy = y + dirs[k][1];
                // not valid neibor
                if (cx < 0 || cx >= m) {
                    continue;
                }
                if (cy < 0 || cy >= n) {
                    continue;
                }
                int nextidx = cx*n+cy;
                if (parent[nextidx] == -1) {
                    continue;
                }

                // connection with value 1
                int next = find(nextidx, parent);
                int cur = find(idx, parent);
                //System.out.println(x + " : " + y + " : " + next + " : " + cur);
                //System.out.println(cx + " : " + cy);
                if (cur != next) {
                    union(idx, nextidx, parent);
                    count--;
                }
            }
            rets.add(count);
        }

        return rets;
    }

}

// private void union(int x, int y) {
//         x = find(x);
//         y = find(y);
//         if (x < y) {
//             parent[y] = x;
//         } else {
//             parent[x] = y;
//         }
//     }
    
//     private int find(int x) {
//         if (x != parent[x]) parent[x] = find(parent[x]);
//         return parent[x];
//     }
