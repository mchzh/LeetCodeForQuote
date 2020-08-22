class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] g : ghosts) {
            int gd = Math.abs(target[0]-g[0]) + Math.abs(target[1]-g[1]);
            if (gd <= dis) return false;
        }
        return true;
    }
}
