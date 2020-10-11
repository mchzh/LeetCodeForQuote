class Solution {
    // https://leetcode.com/problems/dungeon-game/discuss/52790/My-AC-Java-Version-Suggestions-are-welcome
    public int calculateMinimumHP(int[][] dungeon) {
        // dp from bottom to up
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int m = dungeon.length, n = dungeon[0].length;
        
        int[][] health = new int[m][n];
        // initialize
        health[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);
        
        // last row
        for (int i = n-2; i >= 0; i--) {
            health[m-1][i] = Math.max(health[m-1][i+1]-dungeon[m-1][i], 1);
        }
        
        // last column
        for (int i = m-2; i >= 0; i--) {
            health[i][n-1] = Math.max(health[i+1][n-1]-dungeon[i][n-1], 1);
        }
        
        // main framework
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                int right = Math.max(health[i+1][j]-dungeon[i][j], 1);;
                int down = Math.max(health[i][j+1]-dungeon[i][j], 1);;
                health[i][j] = Math.min(right, down);
            }
        }
        return health[0][0];
    }
}

// dp[i][j] = min(right, down)
// right = max(dp[i+1][j]-grid[i][j], 1);
// down = max(dp[i][j+1] - gridp[i][j], 1);
