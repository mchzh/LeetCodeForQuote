class Solution {
    // binary search: all positive be able to use binary search
    // presum i , j , len
    int m, n;
    int[][] presum;
    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        presum = new int[m+1][n+1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                presum[i][j] = presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1] + mat[i-1][j-1];
            }
        }
        
        int left = 1, right = Math.min(m,n);
        while (left < right) {
            int mid = right - (right-left) /2;
            if (isMatched(mid, threshold)) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        if (isMatched(left, threshold)) return left;
        else return 0;
    }
    private boolean isMatched(int len, int threshold) {
        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                int sum = presum[i][j] - presum[i][j-len] - presum[i-len][j] + presum[i-len][j-len];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}

// presum:

// sum i, j : sum[i][j] = presum[i][j] - presum[i][j-len] - presum[i-len][j] + presum[i-len][j-len]
// isok(len): left = mid, otherwise right = mid-1
