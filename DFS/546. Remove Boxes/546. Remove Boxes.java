class Solution {
    int[][][] dp = new int[100][100][100];
    public int removeBoxes(int[] boxes) {
        return dfs(0, boxes.length-1, 0, boxes);
    }
    private int dfs(int l, int r, int k, int[] boxes) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];//memo
        
        int count = k;
        int i = r; // num[r] is a base number
        while (i >= 0 && boxes[i] == boxes[r]) {
            i--;
            count++;
        }
        dp[l][r][k] = dfs(l, i, 0, boxes) + count*count;
        
        for (int j = i; j >= l; j--) {
            if (boxes[j] != boxes[r]) continue;
            if (boxes[j] == boxes[r] && boxes[j] == boxes[j+1]) continue;
            
            dp[l][r][k] = Math.max(dp[l][r][k], dfs(l, j, count, boxes) + dfs(j+1, i, 0, boxes));
        }
        
        return dp[l][r][k];
    }
}

// dp[l][r][k]

// ... OOO XXX OOO XXX OOO
// ...  j1  i1  j0  i0   r
// 1. dp[l][r][k] = dp[l][i0][0] + count*count;
// 2. dp[l][r][k] = dp[l][j0][count] + dp[j0+1][i0][0];
