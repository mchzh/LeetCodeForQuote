class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<vector<int>>>graph(n);
        for (auto f : flights) 
            graph[f[0]].push_back({f[1], f[2]});
        
        auto visited = vector<vector<int>>(n, vector<int>(k+2, INT_MAX/2));
        visited[src][0] = 0;
        multiset<vector<int>>Set;
        Set.insert({0,0,src});
        
        while (!Set.empty()) {
            int cost = (*Set.begin())[0];
            int steps = (*Set.begin())[1];
            int cur = (*Set.begin())[2];
            Set.erase(Set.begin());
    
            if (cur == dst) return cost;
            if (steps == k+1) continue;
            
            for (auto next : graph[cur]) {
                if (cost + next[1] < visited[next[0]][steps+1]) {
                    visited[next[0]][steps+1] = cost + next[1];
                    Set.insert({cost + next[1], steps+1, next[0]});
                }
                
            }
        }
        
        return -1;
    }
};
