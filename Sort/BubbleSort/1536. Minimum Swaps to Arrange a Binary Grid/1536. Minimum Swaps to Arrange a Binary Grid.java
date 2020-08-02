class Solution {
    // bubble sort
    // https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/discuss/767912/Java-16-lines-bubble-sort-with-line-by-line-explanation-easy-to-understand
    public int minSwaps(int[][] grid) {
        int N = grid.length;
        // store the trail zero info
        List<Integer> rows = new ArrayList<>();
        for (int[] g : grid) {
            int countOfTrailZero = 0;
            for (int i = g.length-1; i >= 0 && g[i] == 0; i--) {
                countOfTrailZero++;
            }
            rows.add(countOfTrailZero);
        }
        // bubble sort
        int ret = 0;
        for (int i = 0, targetTrailZero = N-1; i < grid.length; i++,targetTrailZero--) {
            // find the matched content inside rows
            int satisfyRow = i;
            while (satisfyRow < N && rows.get(satisfyRow) < targetTrailZero) satisfyRow++;
            if (satisfyRow == N) return -1;
            if (satisfyRow == i) continue;
            int toRemove = rows.remove(satisfyRow);
            rows.add(i, toRemove);
            ret += satisfyRow-i;
        }
        return ret;
    }
}
