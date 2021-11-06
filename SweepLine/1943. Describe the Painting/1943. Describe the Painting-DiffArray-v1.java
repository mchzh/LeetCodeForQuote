class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        long[] map = new long[100005];
        Set<Integer> set = new HashSet<>();
        for (int[] s : segments) {
            map[s[0]] += s[2];
            map[s[1]] -= s[2];
            set.add(s[0]);
            set.add(s[1]);
        }
        
        List<List<Long>> rets = new ArrayList<>();
        long start = -1, end = -1;
        long sum = 0;
        for (int i = 0; i < map.length; i++) {
            if (!set.contains(i)) continue;
            long pos = i;
            long diff = map[i];
            
            if (start == -1) {
                start = pos;
            } else {
                end = pos;
                rets.add(Stream.of(start, end, sum).collect(Collectors.toCollection(ArrayList::new)));
                start = end;
            }
            
            sum += diff;
            if (sum == 0) start = -1;
        }
        return rets;
    }
}
