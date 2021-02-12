class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        // dfs + memo or dp
        int n = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>(); // stone -> collection of unit
        for (int i = 0; i < n; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        
        for (int i = 0; i < n; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k-1; step <= k+1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        
        return map.get(stones[n-1]).size() > 0;
    }
}
