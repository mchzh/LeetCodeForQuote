class Solution {
    int dp[2001][1024];
    int totalCnt[2001];
    int count[2001][1024];
public:
    int minChanges(vector<int>& nums, int k) {
        int n = nums.size();
        for (int i = 0; i < k; i++) {
            for (int j = i; j < n; j += k) {
                totalCnt[i]++;
                count[i][nums[j]]++;
            }
        }
        for (int d = 0; d < 1024; d++) {
            dp[0][d] = totalCnt[0]-count[0][d];
        }
       
        for (int i = 1; i < k; i++) {
            // the minimun number of dp[i-1][X]
            int minCost = INT_MAX;
            int x;
            for (int d = 0; d < 1024; d++) {
                if (dp[i-1][d] < minCost) {
                    minCost = dp[i-1][d];
                    x = d;
                }
            }
            
            for (int d = 0; d < 1024; d++) {
                dp[i][d] = minCost + (totalCnt[i]-count[i][d^x]);
                
                for (int j = i; j < n; j += k) {
                    int v = nums[j];
                    dp[i][d] = min(dp[i][d], dp[i-1][d^v] + (totalCnt[i]-count[i][v]));
                }
            }
        }
        
        return dp[k-1][0];
    }
};
