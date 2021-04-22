class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return 0;
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>(); // sum -> counter
        for (List<Integer> w : wall) {
            int sum = 0;
            for (int i = 0; i < w.size()-1; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        
        int rets = n;
        for (int key : map.keySet()) {
            rets = Math.min(rets, n-map.get(key));
        }
        return rets;
    }
}
