class Solution {
public:
    int bestTeamScore(vector<int>& scores, vector<int>& ages) {
        int n = scores.size();
        vector<pair<int, int>>player;
        for (int i = 0; i < n; i++) {
            player.push_back({ages[i], scores[i]});
        }
        sort(player.begin(), player.end());
        
        vector<int>dp(n, 0); // choose in ith pos
        for (int i = 0; i < n; i++) {
            dp[i] = player[i].second;
            for (int j = 0; j < i; j++) {
                if (player[j].second <= player[i].second) {
                    dp[i] = max(dp[i], dp[j]+player[i].second);
                }
            }
        }
        
        // last step: tranverse the every element of dp
        int rets = 0;
        for (auto x : dp) {
            rets = max(rets, x);
        }
        return rets;
    }
};

// LIS: Longest increasing subsequence
//      Longest-sum increasing subsequce
     
// X X X X X X i
//       j
//       if j < i dp[i] = max or min(dp[i] , dp[j] + 1)
// dp[i]: the sum score of end with i pos 
// dp[i] = dp[j] + scores[i] for j < i s.t. scores[j] < scores[i]
