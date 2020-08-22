class Solution {
    // set save lake i
    public int[] avoidFlood(int[] rains) {
        // sorted set and map for current lake and day
        int N = rains.length;
        TreeSet<Integer> dryDays = new TreeSet<>();
        Map<Integer, Integer> fills = new HashMap<>();
        //int[] fills = new int[N];
        
        int[] res = new int[N];
        Arrays.fill(res, 1);
        for (int i = 0; i < N; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
            } else {
                int x = rains[i];
                if (fills.containsKey(x)) {
                    int addDay = fills.get(x);
                    Integer drainLakeDay = dryDays.ceiling(addDay);
                    if (drainLakeDay == null) return new int[0];
                    else {
                        dryDays.remove(drainLakeDay);
                        res[drainLakeDay] = x; // x is lake
                    }
                }
                fills.put(x, i); 
                res[i] = -1;
            }
        }
        return res;
    }
}

// rain i > 0 : set has this val or not
// rain i = 0 : set is empty or not
// relationship between day and lake
// rain i == 0 :
//     do nothing, only need to record dry day
//     dryDays.insert(i);
// rain i == x :
//     (1) x is empty -> fill[x] = rain[i];
//     (2) x is full  -> update or not this depend on
//         when to drain x?
//         a) must in dryDays
//         b) must be later than fill[x]
//         fill store the previous push water for lake x
        
//         x _ y _ x y
//           1   2  3  4  5  6
// fill d:   x      y     x  y
// dry  d:       _     _
//         (error)y     x
