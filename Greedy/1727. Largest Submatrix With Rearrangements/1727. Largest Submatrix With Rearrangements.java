class Solution {
    // 84 largest rectangle
    public int largestSubmatrix(int[][] matrix) {
        // get hieight val for every row then sort it to get max retacgle
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int rets = 0;
        for (int i = 0; i < m; i++) {
            int[] newh = new int[n];
            for (int j = 0; j < n; j++) {
                int cur = matrix[i][j];
                newh[j] = cur == 0 ? 0 : height[j] + 1;
            }
            height = Arrays.copyOf(newh, n);
            Arrays.sort(newh);
            for (int s = 0; s < n; s++) {
                if (newh[s] == 0) continue;
                rets = Math.max(rets, newh[s]*(n-s)); // h* len
            }
        }
        return rets;
    }
}
