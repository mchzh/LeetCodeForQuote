class Solution {
public:
    int minDistance(vector<int>& houses, int K) {
        int N = houses.size();
        sort(houses.begin(), houses.end());
        houses.insert(houses.begin(), INT_MIN);
        // calculate the manhaton distance
        // three loop
        int range[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                range[i][j] = 0;
                // get median point
                for (int k = i; k <= j; k++) {
                    range[i][j] += abs(houses[k] - houses[(i+j)/2]);
                }
            }
        }
        
        auto dp = vector<vector<int>>(N+1, vector<int>(K+1));
        //dp[i][1]
        for (int i = 1; i <= N; i++) {
            dp[i][1] = range[1][i];
        }
        
        for (int i = 1; i <= N; i++) {
            for (int k = 2; k <= K; k++) {
                dp[i][k] = INT_MAX/2;
                for (int j = 0; j+1 <= i; j++) {
                    dp[i][k] = min(dp[i][k], dp[j][k-1] + range[j+1][i]);
                }
            }
        }
        return dp[N][K];
    }
};
