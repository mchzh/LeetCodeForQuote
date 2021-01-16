class Solution {
    int[][] dp = new int[13][4096];
    int[] time = new int[4096];
    boolean[][] memo = new boolean[4096][12];
    int num;
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        num = k;
        // time subset
        for (int state = 0; state < (1<<n); state++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ( ((state>>i)&1) == 1 ) sum += jobs[i]; 
            }
            time[state] = sum;
        }
        
        int low = 1;
        int high = 0;
        for (int j : jobs) {
            high += j;
        }
        // binary search
        while (low < high) { // the range of double close
            // initilized memo
            for (boolean[] m : memo) {
                Arrays.fill(m, true);
            }
            
            int mid = low + (high - low) / 2;
            if (dfs((1<<n)-1, mid, 0)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean dfs(int state, int th, int m) {
        // base case
        if (state == 0) return true;
        if (m == num) return false;
        
        if (memo[state][m] == false) return false;
        
        for (int subset = state; subset > 0;  subset = (subset-1)&state) {
            if (time[subset] > th) continue;
            if (dfs(state-subset, th, m+1)) return true;
        }
        return memo[state][m] = false;
    }
}

// bitmask
// dp[i][state] : the minimum possible maximum working time of 
//                 the first i workers to do the state work (1 do, 0 not do)
                    
// dp[i][state] = min( max(dp[i-1][state-subset], time[subset])) for every subset: subset [0.... state]

// [9899456,8291115,9477657,9288480,5146275,7697968,8573153,3582365,3758448,9881935,2420271,4542202]
// 9  => TLE => use memo to solve
