class Solution {
public:
    int minCost(int n, vector<int>& cuts) {
        sort(cuts.begin(), cuts.end());
        cuts.insert(cuts.begin(), 0);
        cuts.push_back(n);
        
        int m = cuts.size();
        auto dp = vector<vector<int>>(m, vector<int>(m, INT_MAX/2));
        for (int i = 0; i+1 < m; i++) {
            dp[i][i+1] = 0;
        }
        
        for (int len = 3; len <= m; len++) {
            for (int i = 0; i+len-1 < m; i++) {
                int j = i+len-1;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = min( dp[i][j], dp[i][k] + dp[k][j] + (cuts[j]-cuts[i]) );
                }
            }
        }
        return dp[0][m-1];
    }
};

// [X X X X X X]
//    i  k   j  j-i
  
// dp[i][j]: the minimum total cost of the cuts between cuts[i] and cuts[j]

// dp[i][j] = min (dp[i][k] + dp[k][j] + currentcost (cuts[j]-cuts[i]) ) k .st i+1, i+2, ... j-1
       
