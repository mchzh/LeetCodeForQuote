class Solution {
    int[][] dp = new int[13][4096];
    int[] time = new int[4096];
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        // time subset
        for (int state = 0; state < (1<<n); state++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ( ((state>>i)&1) == 1 ) sum += jobs[i]; 
            }
            time[state] = sum;
        }
        
        for (int state = 0; state < (1<<n); state++) {
            dp[0][state] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        
        // three loop
        // first for k workers, second for job state(bitmask), last loop for subset state
        for (int i = 1; i <= k; i++) {            
            for (int state = 0; state < (1<<n); state++) {
                dp[i][state] = Integer.MAX_VALUE;
                for (int subset = state; subset > 0; subset=(subset-1)&state) {
                    dp[i][state] = Math.min(dp[i][state], Math.max(dp[i-1][state-subset], time[subset]));
                }
            }
        }
        
        return dp[k][(1<<n)-1];
    }
}

// bitmask
// dp[i][state] : the minimum possible maximum working time of 
//                 the first i workers to do the state work (1 do, 0 not do)
                    
// dp[i][state] = min( max(dp[i-1][state-subset], time[subset])) for every subset: subset [0.... state]
