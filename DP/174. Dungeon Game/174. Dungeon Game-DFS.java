public class Solution {
    /**
     * @param dungeon: a 2D array
     * @return: return a integer
     */
    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[] dx = new int[]{0, 1};
    int[] dy = new int[]{1, 0};
    int minHP = Integer.MIN_VALUE;
    
    public int calculateMinimumHP(int[][] dungeon) {
        // write your code here
        dfs(dungeon, Integer.MAX_VALUE, dungeon[0][0], new Pair(0, 0));
        return minHP > 0 ? 1 : (-1) * minHP + 1;
    }
    // min: minimum blood required, blood: current blood value
    private void dfs(int[][] dungeon, int min, int blood, Pair cur) {
        int nMin = Math.min(min, blood);
        if (nMin < minHP) return;
        if (cur.x == dungeon.length - 1 && cur.y == dungeon[0].length - 1) {
            minHP = Math.max(minHP, nMin);
            return;
        }
        for (int i = 0; i < 2; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];
            if (nx < dungeon.length && ny < dungeon[0].length) {
                dfs(dungeon, nMin, blood + dungeon[nx][ny], new Pair(nx, ny));
            }
        }
    }
}
