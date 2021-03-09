typedef pair<int, int> PII;

class Solution {
    vector<PII> next[20001];
    int visited[20001];
    int dist[20001];
    long memo[20001];
    int n;
    long M = 1e9+7;
public:
    int countRestrictedPaths(int n, vector<vector<int>>& edges) {
        this->n = n;
        for (auto e : edges) {
            next[e[0]-1].push_back({e[1]-1, e[2]});
            next[e[1]-1].push_back({e[0]-1, e[2]});
        }
        
        priority_queue<PII, vector<PII>, greater<>>pq;
        pq.push({0, n-1});
        while (!pq.empty()) {
            auto [d, cur] = pq.top();
            pq.pop();
            if (visited[cur]) continue;
            dist[cur] = d;
            visited[cur] = 1;
            
            for (auto [nxt, len] : next[cur]) {
                if (visited[nxt]) continue;
                pq.push({d + len, nxt});
            }
        }
        
        for (int i = 0; i < n; i++) memo[i] = -1;
        long ret = dfs(0);
        return ret;
    }
    long dfs(int pos) {
        if (pos == n-1) {
            return 1;
        }
        if (memo[pos] != -1) return memo[pos];
        long sum = 0;
        for (auto [nxt, len] : next[pos]) {
            if (dist[pos] <= dist[nxt]) continue;
            sum += dfs(nxt);
            sum %= M;
        }
        memo[pos] = sum;
        return memo[pos];
    }
};
