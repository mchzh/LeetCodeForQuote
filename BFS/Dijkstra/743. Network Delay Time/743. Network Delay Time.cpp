class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int N, int K) {
        vector<int>EarlistTimes(N+1, INT_MAX);
        EarlistTimes[K] = 0;
        
        unordered_map<int, vector<pair<int, int>>>map;
        for (auto& t : times) {
            map[t[0]].push_back({t[1], t[2]});
        }
        
        queue<pair<int, int>> q; // {node, arrivalTime}
        q.push({K, 0});
        while (!q.empty()) {
            int cur = q.front().first;
            int arrivalTime = q.front().second;
            q.pop();
            if (arrivalTime > EarlistTimes[cur]) continue;
            
            for (auto a : map[cur]) {
                int next = a.first;
                int weight = a.second;
                
                if (arrivalTime + weight < EarlistTimes[next]) {
                    EarlistTimes[next] = arrivalTime + weight;
                    q.push({next, arrivalTime + weight});
                }
            }
        }
        
        int ret = 0;
        for (int i = 1; i <= N; i++) {
            ret = max(ret, EarlistTimes[i]);
        }
        return (ret == INT_MAX) ? -1 : ret;
    }
    
//     int networkDelayTimeFloyd(vector<vector<int>>& times, int N, int K) {
//         auto dp= vector<vector<int>>(N+1, vector<int>(N+1, INT_MAX/2));
//         for (auto t : times) {
//             dp[t[0]][t[1]] = t[2];
//         }
//         for (int i = 0; i <= N; i++) {
//             dp[i][i] = 0;
//         }
        
//         for (int k = 1; k <= N; k++) {
//             for (int i = 1; i <= N; i++) {
//                 for (int j = 1; j <= N; j++) {
//                     dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
//                 }
//             }
//         }
//         int ret = 0;
//         for (int i = 1; i <= N; i++) {
//             ret = max(ret, dp[K][i]);
//         }
//         return ret == INT_MAX/2 ? -1 : ret;
//     }
};
