class Solution {
    // topological sort
    int[] Father;
    private int FindFather(int x) {
        if (Father[x] != x) {
            Father[x] = FindFather(Father[x]);
        }
        return Father[x];
    }    
    
    private void Union(int x, int y) {
        x = Father[x];
        y = Father[y];
        if (x < y)
            Father[y] = x;
        else
            Father[x] = y;
    }
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Father = new int[m*n];
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Father[i*n+j] = i*n+j;
            }
        }
        
        // every row
        for (int i =0; i < m; i++) {
            int[][] temp = new int[n][2];
            for (int j = 0; j < n; j++) {
                temp[j][0] = matrix[i][j];
                temp[j][1] = i*n+j;
            }
            Arrays.sort(temp, (a, b) -> (a[0]-b[0]));
            for (int j = 1; j < n; j++) {
                if (temp[j-1][0] == temp[j][0]) {
                    // union
                    if (FindFather(temp[j-1][1]) != FindFather(temp[j][1])) Union(temp[j-1][1], temp[j][1]);
                }
            }
        }
        // ervery col
        for (int j =0; j < n; j++) {
            int[][] temp = new int[m][2];
            for (int i = 0; i < m; i++) {
                temp[i][0] = matrix[i][j];
                temp[i][1] = i*n+j;
            }
            Arrays.sort(temp, (a, b) -> (a[0]-b[0]));
            for (int i = 1; i < m; i++) {
                if (temp[i-1][0] == temp[i][0]) {
                    // union
                    if (FindFather(temp[i-1][1]) != FindFather(temp[i][1])) Union(temp[i-1][1], temp[i][1]);
                }
            }
        }
        // map all element with the same father as one group
        Map<Integer, List<Integer>> group = new HashMap<>();
        // sort all member
        int[][] nums = new int[m*n][2];
        int idx = 0;
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int root = FindFather(i*n+j);
                group.computeIfAbsent(root, k -> new ArrayList<>()).add(i*n+j);
                nums[idx][0] = matrix[i][j];
                nums[idx][1] = i*n+j;
                idx++;
            }
        }
        Arrays.sort(nums, (a, b) -> (a[0]-b[0]));
        
        // from the smallest begint to gradully visit other point
        int[][] rets = new int[m][n];
        int[] rowRank = new int[m];
        int[] colRank = new int[n];
        for (int[] p : nums) {
            int x = p[1]/n;
            int y = p[1]%n;
            if (rets[x][y] != 0) continue;
            
            int root = Father[p[1]];
            int r = 0;
            for (int member : group.get(root)) {
                r = Math.max(r, rowRank[member/n]);
                r = Math.max(r, colRank[member%n]);
            }
            // update row and col rand
            for (int member : group.get(root)) {
                rets[member/n][member%n] = r+1;
                rowRank[member/n] = r+1;
                colRank[member%n] = r+1;
            }
        }
        return rets;
    }
}
