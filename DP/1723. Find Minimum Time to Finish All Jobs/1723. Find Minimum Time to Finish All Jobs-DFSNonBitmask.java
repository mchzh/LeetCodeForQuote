class Solution {
    
    public int minimumTimeRequired(int[] jobs, int k) {
        // dfs by traditional
        int n = jobs.length;
        
        Arrays.sort(jobs);
        int[] cjobs = new int[n]; // reverse the order
        for (int i = n-1; i >= 0; i--) {
            cjobs[n-1-i] = jobs[i];
        }
        
        int low = 1;
        int high = 0;
        for (int j : jobs) {
            high += j;
        }
        int[] workers = new int[k];
        
        // binary search
        while (low < high) { // the range of double close 
            Arrays.fill(workers, 0);
            int mid = low + (high - low) / 2;
            if (dfs(workers, cjobs, mid, 0)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean dfs(int[] workers, int[] jobs, int th, int m) {
        // base case
        if (m == jobs.length) return true;
        
        // for prune to sort the jobs and check the idle workers
        int flag = 0;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] + jobs[m] > th) continue;
            
            if (workers[i] == 0) {
                if (flag == 1) continue;
                else flag = 1;
            }
            
            workers[i] += jobs[m];
            if (dfs(workers, jobs, th, m+1)) return true;
            workers[i] -= jobs[m];
        }
        return false;
    }
}

// bitmask
// dp[i][state] : the minimum possible maximum working time of 
//                 the first i workers to do the state work (1 do, 0 not do)
                    
// dp[i][state] = min( max(dp[i-1][state-subset], time[subset])) for every subset: subset [0.... state]

// [9899456,8291115,9477657,9288480,5146275,7697968,8573153,3582365,3758448,9881935,2420271,4542202]
// 9  => TLE => use memo to solve
