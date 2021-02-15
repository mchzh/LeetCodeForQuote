class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new HashSet<>()).add(e[0]);
        }
        int[] degrees = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i) || map.get(i).size() <= 2) continue;
            degrees[i] = map.get(i).size() - 2;
        }
        
        int rets = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) continue;
            for (int j = i+1; j <= n; j++) {
                if (!map.containsKey(j)) continue;
                for (int k = j+1; k <= n; k++) {
                    if (!map.containsKey(k)) continue;
                    Set<Integer> first = map.get(i);
                    if (first.contains(j) && first.contains(k)) {
                        Set<Integer> second = map.get(j);
                        if (second.contains(i) && second.contains(k)) {
                            Set<Integer> third = map.get(k);
                            if (third.contains(j) && third.contains(i)) rets = Math.min(rets, degrees[i] + degrees[j] + degrees[k]);
                        }
                    }
                }
            }
        }
        
        return rets == Integer.MAX_VALUE ? -1 : rets;
    }
}
