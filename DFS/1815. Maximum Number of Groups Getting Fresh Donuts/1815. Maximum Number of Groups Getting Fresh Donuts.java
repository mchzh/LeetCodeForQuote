class Solution {
    int batch;
    int n;
    Map<Long, Integer> memo;
    public int maxHappyGroups(int batchSize, int[] groups) {
        batch = batchSize;
        n = groups.length;
        long[] count = new long[batch];
        for (int g : groups) {
            count[g%batch]++;
        }
        memo = new HashMap<>();
        long state = 0;
        for (int i = 0; i < batch; i++) {
            state += count[i]<<(i*5);
        }
        
        return dfs(state, 0, 0);
    }
    private int dfs(long state, int presum, int pos) {
        if (pos == n) return 0;
        
        if (memo.containsKey(state)) return memo.get(state);
        int rets = 0;
        int bonus = (presum%batch) == 0 ? 1 : 0;
        for (int i = 0; i < batch; i++) {
            if ((state>>(i*5))%32 == 0) continue;
            state -= (long)1<<(i*5);
            rets = Math.max(rets, dfs(state, (presum+i)%batch, pos+1));
            state += (long)1<<(i*5);
        }
        memo.put(state, bonus+rets);
        return bonus+rets;
    }
}

// batch = 5
    
// 3 2 | 5 | 3 4 3| 2
    
// 30*30*30.... = 30!

// bukcet max 9
// 9*9*9*.... = 9^30

// 4*4*4... = 4^8
// dfs -> TLE -> dfs + memo (permutation with remainder)
// XXXXX XXXXX XXXXX 00100 XXXXX.... 5*9 = 45 state
// every five digits represent the num of group with this remainder
