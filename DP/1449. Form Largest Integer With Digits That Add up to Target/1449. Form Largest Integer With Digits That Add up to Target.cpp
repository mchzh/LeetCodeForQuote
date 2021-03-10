class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {
        string dp[target+1];
        for (int c = 1; c <= target; c++) {
            dp[c] = "#";
            for (int i = 1; i <= 9; i++) {
                if (c < cost[i-1] || dp[c-cost[i-1]] == "#") continue;
                string cur = dp[c-cost[i-1]] + (char)(i+'0');
                
                if (cur.size() > dp[c].size() || (cur.size() == dp[c].size() && cur > dp[c])) {
                    dp[c] = cur;
                } 
            }
        }

        if (dp[target] == "#") return "0";
        else return dp[target];
    }
};

// 01 Knapscak

// obj[i] cap
// dp[c]: the maximun goal if using c
// for i in obj
//     for c in capacity
//         dp[i][c] = max(dp[i-1][c], dp[i-1][c-cost[i]]+vali[i]);
// return max{dp[n][c]} for c = ....
    
// unlimited knapsack
// for c in capacity
//     for i in obj
//         dp[c] = max(dp[c], dp[c-cost[i]]+vali[i]);
// return max{dp[c]} for c = ....
