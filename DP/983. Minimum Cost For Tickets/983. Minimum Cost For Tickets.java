class Solution {
    // dp
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> exist = new HashSet<>();
        //exist = Arrays.stream(days).collect(Collectors.toSet());
        for (int day : days) {
            exist.add(day);
        }
        int[] dp = new int[366];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        
        dp[0] = 0;
        int lastday = days[days.length-1];
        for (int i = 1; i <= lastday; i++) {
            if (!exist.contains(i)) {
                dp[i] = dp[i-1];
                continue;
            }
            int a = dp[Math.max(0,i-1)] + costs[0];
            int b = dp[Math.max(0,i-7)] + costs[1];
            int c = dp[Math.max(0,i-30)] + costs[2];
            //System.out.println("fits -> " + a + " : second -> " + b + " : last -> " + c);
            dp[i] = Math.min(a, Math.min(b, c));
        }
        return dp[lastday];
    }
}

// dp[i] : the cost for the first ith day you can travel
// if (i not in days) dp[i] = dp[i-1]
// dp[i] : = min(dp[i-1] + cost1, dp[i-7] + cost2, dp[i-30] + cost3);

// dp[i-2] + cost2
// any j < i, dp[j] <= dp[i]

/*class Solution {
    // https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226672/JAVA-1-D-DP-Time-Space-O(1)
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        boolean[] isDays = new boolean[366];
        for (int day : days) {
            isDays[day] = true;
        }
        
        
        for (int i = 1; i < 366; i++) {
            if (!isDays[i]) {
                dp[i] = dp[i-1]; // not in days
                continue;
            }
            
            int cur;
            // case 1
            cur = dp[i-1]+costs[0];
            // case 2
            cur = Math.min(cur, dp[Math.max(0, i-7)]+costs[1]);
            // case3
            cur = Math.min(cur, dp[Math.max(0, i-30)]+costs[2]);
            
            dp[i] = cur;
        }
        return dp[365];
    }
}*/
