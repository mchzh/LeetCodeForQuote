class Solution {
    // dfs -> mahanton distance -> both dfs
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> block = new HashSet<>();
        for (int[] b : blocked) block.add(b[0]+ "->" + b[1]);
        
        return dfs(source, target, source, block, new HashSet<>()) && dfs(target, source, target, block, new HashSet<>());
    }
    private boolean dfs(int[] src, int[] tar, int[] cur, Set<String> block, Set<String> visited) {
        if (cur[0] == tar[0] && cur[1] == tar[1]) return true; // reach the target
        if (Math.abs(cur[0]-src[0]) + Math.abs(cur[1]-src[1]) > 200) return true; // manhhanton dis > 200
        
        visited.add(cur[0]+ "->" + cur[1]);
        int[][] dirs = {{1, 0}, {-1, 0}, {0,1}, {0,-1}};
        for (int k = 0; k < 4; k++) {
            int cx = cur[0] + dirs[k][0];
            int cy = cur[1] + dirs[k][1];
            if (cx < 0 || cx >= 1000000) continue;
            if (cy < 0 || cy >= 1000000) continue;
            String next = cx + "->" + cy;
            if (visited.contains(next)) continue;
            if (block.contains(next)) continue;
            if (dfs(src, tar, new int[] {cx, cy}, block, visited)) return true;
        }
        return false;
    }
}
