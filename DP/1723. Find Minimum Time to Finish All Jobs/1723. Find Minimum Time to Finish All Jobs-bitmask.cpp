class Solution {
    int dp[13][4096];
    int time[4096];
public:
    int minimumTimeRequired(vector<int>& jobs, int k) {
        int n = jobs.size();
        // time subset
        for (int state = 0; state < (1<<n); state++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ( ((state>>i)&1) == 1 ) sum += jobs[i]; 
            }
            time[state] = sum;
        }
        
        for (int state = 0; state < (1<<n); state++) {
            dp[0][state] = INT_MAX;
        }
        dp[0][0] = 0;
        
        // three loop
        // first for k workers, second for job state(bitmask), last loop for subset state
        for (int i = 1; i <= k; i++) {            
            for (int state = 0; state < (1<<n); state++) {
                dp[i][state] = INT_MAX;
                for (int subset = state; subset > 0; subset=(subset-1)&state) {
                    dp[i][state] = min(dp[i][state], max(dp[i-1][state-subset], time[subset]));
                }
            }
        }
        
        return dp[k][(1<<n)-1];
    }
};
