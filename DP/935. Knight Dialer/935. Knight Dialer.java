class Solution {
    public int knightDialer(int n) {
        int mod = (int)(1e9+7);
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[] {4, 6});
        map.put(1, new int[] {8, 6});
        map.put(2, new int[] {7, 9});
        map.put(3, new int[] {4, 8});
        map.put(4, new int[] {0, 3, 9});
        map.put(6, new int[] {0, 1, 7});
        map.put(7, new int[] {2, 6});
        map.put(8, new int[] {1, 3});
        map.put(9, new int[] {4, 2});
        
        for (int i = 2; i <= n; i++) {
            int[] old_dp = Arrays.copyOf(dp, dp.length);
            for (int j = 0; j <= 9; j++) {
                dp[j] = 0;
                if (!map.containsKey(j)) continue;
                int[] cur = map.get(j);
                for (int c : cur) {
                    dp[j] += old_dp[c];
                    dp[j] %= mod;
                }
            }
        }
        int rets = 0;
        for (int i = 0; i < 10; i++) {
            //System.out.println(i + " " + dp[i]);
            rets += dp[i];
            rets %= mod;
        }
        return rets;
    }
}
// cur      prev
// dp[1] :  dp[6] and dp[8]
// dp[2] :  dp[7] and dp[9]
// dp[0] :  dp[4] and dp[6]
// dp[3] :  dp[8] and dp[4]
// dp[4] :  dp[3] and dp[9] and dp[0]
// dp[5] :  dp[x] and dp[x]
// dp[6] :  dp[1] and dp[7] and dp[0]
// dp[7] :  dp[2] and dp[6]
// dp[8] :  dp[1] and dp[3]
// dp[9] :  dp[4] and dp[2]
