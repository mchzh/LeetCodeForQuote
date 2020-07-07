class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& arr) {
        int m = arr.size();
        int n = arr[0].size();
        
        auto dp = vector<vector<int>>(m, vector<int>(n));
        // first step 
        for (int j = 0; j < n; j++) {
            dp[0][j] = arr[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            // get the min1 and min2 of last row
            vector<pair<int, int>> temp;
            for (int k = 0; k < n; k++) {
                temp.push_back({dp[i-1][k], k});
            }
            sort(temp.begin(), temp.end());
            
            for (int j = 0; j < n; j++) {
                if (j != temp[0].second) {
                    dp[i][j] = temp[0].first +arr[i][j];
                } else {
                    dp[i][j] = temp[1].first +arr[i][j] ;
                }
                //dp[i][j] += arr[i][j];
            }
        }
        
        // last step 
        int ret = INT_MAX;
        for (int j = 0; j < n; j++) {
            ret = min(ret, dp[m-1][j]);
        }
        return ret;
    }
};

//dp[i][j] -> the minimum sum of a falling path with non-zero shifts from 0 row to {i, j}
//dp[i][j] = min/min2(dp[i][k] {k = 0,1,2,3,....n-1; k != j}) + arr[i][j]
